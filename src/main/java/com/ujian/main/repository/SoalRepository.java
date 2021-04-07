package com.ujian.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.ujian.main.entity.Soal;

public interface SoalRepository extends CrudRepository<Soal, Long>{
	
	public Soal findByNamaSoal(String nama);

}
