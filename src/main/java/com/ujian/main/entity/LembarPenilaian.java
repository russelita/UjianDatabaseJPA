package com.ujian.main.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LembarPenilaian {
	
	private float benar;
	private float salah;
	private float nilai;

}
