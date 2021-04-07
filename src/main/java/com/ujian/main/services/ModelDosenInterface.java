package com.ujian.main.services;

import java.util.List;

import com.ujian.main.entity.Dosen;

public interface ModelDosenInterface {
	
	public List<Dosen> getAllDosen();
	public Dosen getDosenByName(String nama);
	
	public Dosen addDosen(Dosen dosen);
	public Dosen getDosenById(String id);
	public void deleteDosen(String id);

}
