package com.ujian.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujian.main.entity.Mahasiswa;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long> {

}
