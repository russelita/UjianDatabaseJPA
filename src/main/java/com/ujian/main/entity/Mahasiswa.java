package com.ujian.main.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
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
@Table(name="Mahasiswa")
public class Mahasiswa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nama_mahasiswa")
	private String nm_mh;
	@Column(name="jenis_kelamin")
	private String jk;
	private String password;
	
	@ManyToMany(mappedBy = "lstmh")
	List<PlotMataKuliah> lstplot = new ArrayList<PlotMataKuliah>();
}
