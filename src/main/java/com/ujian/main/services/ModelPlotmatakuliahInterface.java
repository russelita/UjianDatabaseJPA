package com.ujian.main.services;

import java.util.List;

import com.ujian.main.entity.Plotmatakuliah;
import com.ujian.main.entity.Soal;


public interface ModelPlotmatakuliahInterface {
	
	public Plotmatakuliah addPlotmatakuliah(Plotmatakuliah plot);
	public List<Plotmatakuliah> getAllPlotmatakuliah();
	public void deletePlotmatakuliah(String id);
	public Plotmatakuliah cariPlot(String id);
	public List<Soal> addujianPlotmatakuliah(String id);

}
