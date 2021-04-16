package com.ujian.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	private long idMahasiswa;
	@NotEmpty
	@Size(min = 8)
	private String nim;
	@NotEmpty(message = "{Size.Mahasiswa.FullName}")
	private String namaMahasiswa;
	@NotBlank(message = "{Blank.Mahasiswa.JK}")
	private String jenisKelamin;
	@NotBlank(message = "{Blank.Mahasiswa.Password}")
	private String password;
	
}
