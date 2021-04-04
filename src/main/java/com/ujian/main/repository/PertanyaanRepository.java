package com.ujian.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujian.main.entity.Pertanyaan;

public interface PertanyaanRepository extends JpaRepository<Pertanyaan, Long> {

}
