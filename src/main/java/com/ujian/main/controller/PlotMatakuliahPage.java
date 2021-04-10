package com.ujian.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ujian.main.entity.Plotmatakuliah;
import com.ujian.main.entity.Soal;
import com.ujian.main.services.ModelDosen;
import com.ujian.main.services.ModelMK;
import com.ujian.main.services.ModelMahasiswa;
import com.ujian.main.services.ModelPertanyaan;
import com.ujian.main.services.ModelPlotmatakuliah;
import com.ujian.main.services.ModelSoal;

@Controller
public class PlotMatakuliahPage {
	
	@Autowired
	ModelMahasiswa modelMahasiswa;
	
	@Autowired
	ModelDosen modelDosen;
	
	@Autowired
	ModelMK modelMK;
	
	@Autowired
	ModelSoal modelSoal;
	
	@Autowired
	ModelPlotmatakuliah modelPlot;
	
	@Autowired
	ModelPertanyaan modelPertanyaan;
	
	@GetMapping("/plot/view")
	public String viewIndexPlot(Model model) {
		
		model.addAttribute("listPlot",modelPlot.getAllPlotmatakuliah());
		model.addAttribute("listSoal", modelSoal.getAllSoal());
		model.addAttribute("active",6);
		return "view_plot";
	}
	
	@GetMapping("/plot/add")
	public String viewAddPlotmatakuliah(Model model) {
		
		model.addAttribute("plot",new Plotmatakuliah());
		model.addAttribute("listMahasiswa",modelMahasiswa.getAllMahasiswa());
		model.addAttribute("listDosen", modelDosen.getAllDosen());
		model.addAttribute("listMatakuliah", modelMK.getAllMataKuliah());
		model.addAttribute("listSoal", modelSoal.getAllSoal());
		return "add_plot";
	}
	
	@PostMapping("/plot/view")
	  public String addPlotmatakuliah(@ModelAttribute Plotmatakuliah plot, Model model) {
		// buat penampung data plot di halaman htmlnya
		this.modelPlot.addPlotmatakuliah(plot);	
		return "redirect:/plot/view";
	}
	
	@GetMapping("/plot/update/{id}")
	public String viewUpdatePlotmatakuliah(@PathVariable String id, Model model) {
		
		Plotmatakuliah plot = modelPlot.cariPlot(id);
		// buat penampung data soal di halaman htmlnya
		model.addAttribute("plot",plot);
		
		return "add_plot";
	}
	
	@GetMapping("/plot/delete/{id}")
	public String deletePlotmatakuliah(@PathVariable String id, Model model) {
		
		this.modelPlot.deletePlotmatakuliah(id);
		model.addAttribute("listPlot",modelPlot.getAllPlotmatakuliah());
		
		return "redirect:/plot/view";
	}
	
	@GetMapping("/plot/ujian/{id}")
	public String addUjianPlotmatakuliah(@PathVariable String id, Model model) {
		
		Plotmatakuliah plot = modelPlot.cariPlot(id);
		
		model.addAttribute("listSoal", modelSoal.getAllSoal());
		model.addAttribute("plot",plot);
		return "add_ujian";
	}
	
	@PostMapping("/ujian/view")
	  public String addUjianPlotmatakuliah(@ModelAttribute Plotmatakuliah plot, Model model) {
		// buat penampung data plot di halaman htmlnya
		this.modelPlot.addPlotmatakuliah(plot);	
		return "redirect:/ujian/view";
	}
	
	@GetMapping("/ujian/view")
	public String ujianPlotmatakuliah(Model model) {
		
		model.addAttribute("listPlot",modelPlot.getAllPlotmatakuliah());
		model.addAttribute("listSoal", modelSoal.getAllSoal());
		model.addAttribute("active",7);
		
		return "view_plot";
	}


}
