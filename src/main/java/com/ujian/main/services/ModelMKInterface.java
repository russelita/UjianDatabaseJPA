package com.ujian.main.services;

import java.util.List;

import com.ujian.main.entity.MataKuliah;

public interface ModelMKInterface {
	
	public List<MataKuliah> getAllMataKuliah();
	public MataKuliah getMataKuliahByName(String nama);
	
	public MataKuliah addMataKuliah(MataKuliah mk);
	public MataKuliah getMataKuliahById(String id);
	public void deleteMataKuliah(String id);

}
