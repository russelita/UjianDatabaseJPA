package com.ujian.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujian.main.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
