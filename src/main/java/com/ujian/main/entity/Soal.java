package com.ujian.main.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Soal")
public class Soal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int id_soal;
	private String nama_soal;
	private int status;
	
	@ManyToMany(mappedBy = "lstsoal")
	List<PlotMataKuliah> lstplot = new ArrayList<PlotMataKuliah>();

}
