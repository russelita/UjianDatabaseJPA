package com.ujian.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ujian.main.entity.Dosen;
import com.ujian.main.entity.Mahasiswa;
import com.ujian.main.services.ModelDosen;

@Controller
public class DosenPage {
	
	@Autowired
	ModelDosen modelDosen;
	@GetMapping("/dosen/view")
	public String viewIndexDosen(Model model) {
		model.addAttribute("listDosen",modelDosen.getAllDosen());
		
		return "view_dosen";
	}
	
	@GetMapping("/dosen/add")
	public String viewAddDosen(Model model) {
		
		// buat penampung data mahasiswa di halaman htmlnya
		model.addAttribute("dosen",new Dosen());
		
		return "add_dosen";
	}
	
	@PostMapping("/dosen/view")
	  public String addDosen(@ModelAttribute Dosen dosen, Model model) {
		
		// buat penampung data dosen di halaman htmlnya
		this.modelDosen.addDosen(dosen);
		model.addAttribute("listDosen",modelDosen.getAllDosen());
		
		
		return "view_dosen";
	}
	
	@GetMapping("/dosen/update/{id}")
	public String viewUpdateDosen(@PathVariable String id, Model model) {
		
		Dosen dosen = modelDosen.getDosenById(id);
		// buat penampung data dosen di halaman htmlnya
		model.addAttribute("dosen",dosen);
		
		return "add_dosen";
	}
	
	@GetMapping("/dosen/delete/{id}")
	public String deleteDosen(@PathVariable String id, Model model) {
		
		this.modelDosen.deleteDosen(id);
		model.addAttribute("listDosen",modelDosen.getAllDosen());
		
		
		return "view_dosen";
	}

}
