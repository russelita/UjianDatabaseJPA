package com.ujian.main.services;

import java.util.List;

import com.ujian.main.entity.Soal;

public interface ModelSoalInterface {
	
	public Soal addSoal(Soal soal);
	public List<Soal> getAllSoal();
	public void deleteSoal(String id);
	public Soal cariSoal(String id);

}
