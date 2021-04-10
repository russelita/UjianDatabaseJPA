package com.ujian.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ujian.main.entity.Soal;
import com.ujian.main.services.ModelPertanyaan;
import com.ujian.main.services.ModelSoal;

@Controller
public class SoalPage {
	
	@Autowired
	ModelSoal modelSoal;
	
	@Autowired
	ModelPertanyaan modelPertanyaan;
	
	@GetMapping("/soal/view")
	public String viewIndexSoal(Model model) {
		
		model.addAttribute("listSoal",modelSoal.getAllSoal());
		model.addAttribute("active",5);
		return "view_soal";
	}
	
	@GetMapping("/soal/add")
	public String viewAddSoal(Model model) {
		
		model.addAttribute("soal",new Soal());
		model.addAttribute("listPertanyaan", modelPertanyaan.getAllPertanyaan());
		return "add_soal";
	}
	
	@PostMapping("/soal/view")
	  public String addSoal(@ModelAttribute Soal soal, Model model) {
		
		// buat penampung data soal di halaman htmlnya
		this.modelSoal.addSoal(soal);
		model.addAttribute("listSoal",modelSoal.getAllSoal());
		
		
		return "redirect:/soal/view";
	}
	
	@GetMapping("/soal/update/{id}")
	public String viewUpdateSoal(@PathVariable String id, Model model) {
		
		Soal soal = modelSoal.cariSoal(id);
		// buat penampung data soal di halaman htmlnya
		model.addAttribute("soal",soal);
		
		return "add_soal";
	}
	
	@GetMapping("/soal/delete/{id}")
	public String deleteSoal(@PathVariable String id, Model model) {
		
		this.modelSoal.deleteSoal(id);
		model.addAttribute("listSoal",modelSoal.getAllSoal());
		
		return "redirect:/soal/view";
	}

}
