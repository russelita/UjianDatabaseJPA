package com.ujian.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ujian.main.entity.LembarPenilaian;
import com.ujian.main.entity.Pertanyaan;
import com.ujian.main.entity.Plotmatakuliah;
import com.ujian.main.entity.UjianHasil;
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
		model.addAttribute("listPlot",modelPlot.getAllPlotmatakuliah());
		return "redirect:/plot/view";
	}
	
	@GetMapping("/plot/update/{id}")
	public String viewUpdatePlotmatakuliah(@PathVariable String id, Model model) {
		
		Plotmatakuliah plot = modelPlot.getPlotmatakuliahById(id);
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
	public String viewUjian(@PathVariable String id, Model model) {
		
		List<Pertanyaan> lstPertanyaan = new ArrayList<Pertanyaan>();
		
		
		Plotmatakuliah plot = modelPlot.getPlotmatakuliahById(id);
		for (int x = 0 ; x < plot.getLstSoal().size(); x++) {
			
			for (int y = 0 ; y < plot.getLstSoal().get(x).getLstPertanyaan().size();y++) {
				lstPertanyaan.add(plot.getLstSoal().get(x).getLstPertanyaan().get(y));
			
			}
			
			
		}
		
		List<String> lstJawaban = new ArrayList<String>(lstPertanyaan.size());
		
		
		
		UjianHasil ujian = new UjianHasil();
		ujian.setPertanyaan(lstPertanyaan);
		ujian.setJawaban(lstJawaban);
		model.addAttribute("ujian",ujian);
		model.addAttribute("idPlotmata",id);		
		
		
		return "view_ujian";
		
	}
	
	@PostMapping("/plot/ujian/hasil")
	 public String viewHasilUjian(@ModelAttribute UjianHasil ujian,@RequestParam("idPlotmata") String id, Model model) {
		
		List<Pertanyaan> lstPertanyaan = new ArrayList<Pertanyaan>();
		
		
		Plotmatakuliah plot = modelPlot.getPlotmatakuliahById(id);
		for (int x = 0 ; x < plot.getLstSoal().size(); x++) {
			
			for (int y = 0 ; y < plot.getLstSoal().get(x).getLstPertanyaan().size();y++) {
				lstPertanyaan.add(plot.getLstSoal().get(x).getLstPertanyaan().get(y));
			
			}
			
			
		}		
		
		ujian.setPertanyaan(lstPertanyaan);
		
		LembarPenilaian lembar = hitungNilai(ujian);
		model.addAttribute("nilai",lembar);
		
		
		
		return "view_ujian_hasil";
	}
	
	private LembarPenilaian hitungNilai (UjianHasil ujian) {
		
		LembarPenilaian nilai = new LembarPenilaian();
		
		
		
		for(int x =0 ; x < ujian.getJawaban().size();x++) {
			
			if(ujian.getJawaban().get(x).equalsIgnoreCase(ujian.getPertanyaan().get(x).getJawabanBenar())){
				nilai.setBenar(nilai.getBenar()+1);
				
			}else {
				nilai.setSalah(nilai.getSalah()+1);
			}
			
			
			
			
		}
		
		nilai.setNilai(nilai.getBenar()/ujian.getPertanyaan().size()*100);
		
		
		return nilai;
		
	}

}
