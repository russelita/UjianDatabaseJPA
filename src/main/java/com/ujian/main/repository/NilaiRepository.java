package com.ujian.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujian.main.entity.Nilai;

public interface NilaiRepository extends JpaRepository<Nilai, Long> {

}