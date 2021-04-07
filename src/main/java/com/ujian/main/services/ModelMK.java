package com.ujian.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujian.main.entity.MataKuliah;
import com.ujian.main.repository.MKRepository;

@Service
public class ModelMK implements ModelMKInterface {
	
	@Autowired
	MKRepository mkRepo;
	
	@Override
	public List<MataKuliah> getAllMataKuliah() {
		// TODO Auto-generated method stub
		return (List<MataKuliah>)this.mkRepo.findAll();
	}

	@Override
	public MataKuliah getMataKuliahByName(String nama) {
		// TODO Auto-generated method stub
		return this.mkRepo.findByNamaMK(nama);
	}

	@Override
	public MataKuliah addMataKuliah(MataKuliah mk) {
		// TODO Auto-generated method stub
		return  this.mkRepo.save(mk);
	}

	@Override
	public MataKuliah getMataKuliahById(String id) {
		// TODO Auto-generated method stub
		return 	((MataKuliah)this.mkRepo.findByIdMataKuliah(Long.parseLong(id)));
	}

	@Override
	public void deleteMataKuliah(String id) {
		// TODO Auto-generated method stub
		this.mkRepo.deleteById(Long.parseLong(id));
	}

	

	

}
