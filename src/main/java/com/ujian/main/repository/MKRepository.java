package com.ujian.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujian.main.entity.MataKuliah;

public interface MKRepository extends JpaRepository<MataKuliah, Long> {

}
