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
@Table(name="Plotmatakuliah")
public class PlotMataKuliah {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="Soal_id", referencedColumnName = "id")
	List<Soal> lstsoal = new ArrayList<Soal>();
	
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="Dosen_id", referencedColumnName = "id")
	List<Dosen> lstdosen = new ArrayList<Dosen>();
	
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="Matakuliah_id", referencedColumnName = "id")
	List<MataKuliah> lstmk = new ArrayList<MataKuliah>();
	
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="Mahasiswa_id", referencedColumnName = "id")
	List<Mahasiswa> lstmh = new ArrayList<Mahasiswa>();

}
