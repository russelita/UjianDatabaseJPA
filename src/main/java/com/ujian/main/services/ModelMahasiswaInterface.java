package com.ujian.main.services;

import java.util.List;

import com.ujian.main.entity.Mahasiswa;

public interface ModelMahasiswaInterface {
		
		public List<Mahasiswa> getAllMahasiswa();
		public Mahasiswa getMahasiwaByName(String name);
		
		public Mahasiswa addMahasiswa(Mahasiswa mahasiswa);
		public Mahasiswa getMahasiswaById(String id);
		public void deleteMahasiswa(String id);
		

	}
