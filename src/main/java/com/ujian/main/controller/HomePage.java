package com.ujian.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ujian.main.repository.MahasiswaRepository;

@Controller
public class HomePage {
	
	@Autowired
	MahasiswaRepository mhrepo;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		
		model.addAttribute("aqil","Hello ini gw dewa");
		model.addAttribute("hanif","Hanif makan mie");

		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage(Model model) {


		return "login";

	}

	
	

}
