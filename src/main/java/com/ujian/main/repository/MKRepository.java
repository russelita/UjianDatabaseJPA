package com.ujian.main.repository;

import org.springframework.data.repository.CrudRepository;

import com.ujian.main.entity.MataKuliah;

public interface MKRepository extends CrudRepository<MataKuliah, Long> {
	
	public MataKuliah findByNamaMK(String nama);
	public MataKuliah findByIdMataKuliah(Long id);

}
