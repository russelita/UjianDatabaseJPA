package com.ujian.main.services;

import java.util.List;

import com.ujian.main.entity.Plotmatakuliah;


public interface ModelPlotmatakuliahInterface {
	
	public Plotmatakuliah addPlotmatakuliah(Plotmatakuliah plot);
	public List<Plotmatakuliah> getAllPlotmatakuliah();
	public void deletePlotmatakuliah(String id);
	public Plotmatakuliah getPlotmatakuliahById(String id);

}
