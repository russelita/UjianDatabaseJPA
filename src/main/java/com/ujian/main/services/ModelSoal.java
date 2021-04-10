package com.ujian.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujian.main.entity.Soal;
import com.ujian.main.repository.SoalRepository;

@Service
public class ModelSoal implements ModelSoalInterface {
	
	@Autowired
	SoalRepository soalRepo;

	@Override
	public Soal addSoal(Soal soal) {
		// TODO Auto-generated method stub
		return  this.soalRepo.save(soal);
	}

	@Override
	public List<Soal> getAllSoal() {
		// TODO Auto-generated method stub
		return (List<Soal>) this.soalRepo.findAll();
	}

	@Override
	public void deleteSoal(String id) {
		// TODO Auto-generated method stub
		this.soalRepo.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Soal cariSoal(String id) {
		// TODO Auto-generated method stub
		return this.soalRepo.findById(Long.parseLong(id)).get();
	}

}
