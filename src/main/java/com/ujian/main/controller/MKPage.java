package com.ujian.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ujian.main.entity.MataKuliah;
import com.ujian.main.services.ModelMK;

@Controller
public class MKPage {
	
	@Autowired
	ModelMK modelMK;
	@GetMapping("/matakuliah/view")
	public String viewIndexMataKuliah(Model model) {
		model.addAttribute("listMataKuliah",modelMK.getAllMataKuliah());
		
		return "view_matakuliah";
	}
	
	@GetMapping("/matakuliah/add")
	public String viewAddMataKuliah(Model model) {
		
		// buat penampung data mahasiswa di halaman htmlnya
		model.addAttribute("matakuliah",new MataKuliah());
		
		return "add_matakuliah";
	}
	
	@PostMapping("/matakuliah/view")
	  public String addMataKuliah(@ModelAttribute MataKuliah mk, Model model) {
		
		// buat penampung data dosen di halaman htmlnya
		this.modelMK.addMataKuliah(mk);
		model.addAttribute("listMataKuliah",modelMK.getAllMataKuliah());
		
		
		return "view_matakuliah";
	}
	
	@GetMapping("/matakuliah/update/{id}")
	public String viewUpdateMataKuliah(@PathVariable String id, Model model) {
		
		MataKuliah mk = modelMK.getMataKuliahById(id);
		// buat penampung data dosen di halaman htmlnya
		model.addAttribute("matakuliah",mk);
		
		return "add_matakuliah";
	}
	
	@GetMapping("/matakuliah/delete/{id}")
	public String deleteMataKuliah(@PathVariable String id, Model model) {
		
		this.modelMK.deleteMataKuliah(id);
		model.addAttribute("listMataKuliah",modelMK.getAllMataKuliah());
		
		
		return "view_matakuliah";
	}

}
