package com.ujian.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujian.main.entity.Pertanyaan;
import com.ujian.main.repository.PertanyaanRepository;

@Service
public class ModelPertanyaan implements ModelPertanyaanInterface{
	
	@Autowired
	PertanyaanRepository pertanyaanRepo;

	@Override
	public Pertanyaan addPertanyaan(Pertanyaan pertanyaan) {
		// TODO Auto-generated method stub
		return  this.pertanyaanRepo.save(pertanyaan);
	}
	
	@Override
	public List<Pertanyaan> getAllPertanyaan() {
		// TODO Auto-generated method stub
		return (List<Pertanyaan>) this.pertanyaanRepo.findAll();
	}
	
	@Override
	public void deletePertanyaan(String id) {
		// TODO Auto-generated method stub
		this.pertanyaanRepo.deleteById(Long.parseLong(id));
	}
	
	@Override
	public Pertanyaan cariPertanyaan(String id) {
		// TODO Auto-generated method stub
		return this.pertanyaanRepo.findById(Long.parseLong(id)).get();
	}

}
