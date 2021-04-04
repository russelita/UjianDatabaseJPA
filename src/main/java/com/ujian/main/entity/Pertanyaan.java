package com.ujian.main.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Pertanyaan")
public class Pertanyaan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String pertanyaan;
	private String jawaban1;
	private String jawaban2;
	private String jawaban3;
	private String jawaban4;
	private String jawaban_benar;
	private int status_gambar;
	
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="Soal_ID", referencedColumnName = "ID")
	List<Soal> lstsoal = new ArrayList<Soal>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Nilai_ID", referencedColumnName = "ID")
	List<Nilai> lstnilai = new ArrayList<Nilai>();
        
	

}
