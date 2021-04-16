package com.ujian.main.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ujian.main.entity.Mahasiswa;
import com.ujian.main.services.ModelMahasiswa;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
public class MahasiswaPage {
	
	@Autowired
	ModelMahasiswa modelMahasiswa;
	
	@GetMapping("/mahasiswa/view")
	public String viewIndexMahasiswa(Model model) {
		
		model.addAttribute("listMahasiswa",modelMahasiswa.getAllMahasiswa());
		model.addAttribute("active",1);
		
		return "view_mahasiswa";
	}
	
	@GetMapping("/mahasiswa/add")
	public String viewAddMahasiswa(Model model) {
		
		// buat penampung data mahasiswa di halaman htmlnya
		model.addAttribute("mahasiswa",new Mahasiswa());
		
		return "add_mahasiswa";
	}
	
	@PostMapping("/mahasiswa/view") 
	  public String addMahasiswa(@Valid @ModelAttribute Mahasiswa mahasiswa, BindingResult result, Model model) {
		
		// buat penampung data mahasiswa di halaman htmlnya
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String plainPassword = mahasiswa.getPassword();
		String encodedPassword = passwordEncoder.encode(plainPassword);
        mahasiswa.setPassword(encodedPassword);	
		
		model.addAttribute("listMahasiswa",modelMahasiswa.getAllMahasiswa());
		
		if (result.hasErrors()) {
		    return "add_mahasiswa";
		  }
		  this.modelMahasiswa.addMahasiswa(mahasiswa);
		  return "redirect:/mahasiswa/view";
		}
		
	
	@GetMapping("/mahasiswa/update/{id}")
	public String viewUpdateMahasiswa(@PathVariable String id, Model model) {
		
		Mahasiswa mahasiswa = modelMahasiswa.getMahasiswaById(id);
		// buat penampung data mahasiswa di halaman htmlnya
		model.addAttribute("mahasiswa",mahasiswa);
		
		return "add_mahasiswa";
	}
	
	@GetMapping("/mahasiswa/delete/{id}")
	public String deleteMahasiswa(@PathVariable String id, Model model) {
		
		this.modelMahasiswa.deleteMahasiswa(id);
		model.addAttribute("listMahasiswa",modelMahasiswa.getAllMahasiswa());
		
		
		return "redirect:/mahasiswa/view";
	}
	
	@GetMapping("/mahasiswa/print")
	public String exportPDF() {
		try {
		File file = ResourceUtils.getFile("classpath:mahasiswa.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		
		List<Mahasiswa> lstMahasiswa = modelMahasiswa.getAllMahasiswa();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstMahasiswa);
        
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy","Russel");
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        String path = "F:\\mahasiswa.pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        
       
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return "redirect:/mahasiswa/view";
		
				
	}

}
