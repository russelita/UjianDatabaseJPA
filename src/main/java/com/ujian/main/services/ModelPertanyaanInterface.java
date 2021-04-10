package com.ujian.main.services;

import java.util.List;

import com.ujian.main.entity.Pertanyaan;

public interface ModelPertanyaanInterface {
	
	public Pertanyaan addPertanyaan(Pertanyaan pertanyaan);
	public List<Pertanyaan> getAllPertanyaan();
	public void deletePertanyaan(String id);
	public Pertanyaan cariPertanyaan(String id);

}
