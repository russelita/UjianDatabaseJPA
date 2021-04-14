package com.ujian.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujian.main.entity.Plotmatakuliah;
import com.ujian.main.repository.PlotmatakuliahRepository;
@Service
public class ModelPlotmatakuliah implements ModelPlotmatakuliahInterface {
	
	@Autowired
	PlotmatakuliahRepository plotRepo;
	
	@Override
	public Plotmatakuliah addPlotmatakuliah(Plotmatakuliah plot) {
		// TODO Auto-generated method stub
		return  this.plotRepo.save(plot);
	}

	@Override
	public List<Plotmatakuliah> getAllPlotmatakuliah() {
		// TODO Auto-generated method stub
		return (List<Plotmatakuliah>) this.plotRepo.findAll();
	}

	@Override
	public void deletePlotmatakuliah(String id) {
		// TODO Auto-generated method stub
		this.plotRepo.deleteById(Long.parseLong(id));
	}
	
	@Override
	public Plotmatakuliah getPlotmatakuliahById(String id) {
		// TODO Auto-generated method stub
		return 	(Plotmatakuliah)this.plotRepo.findById(Long.parseLong(id)).get();
	}

}
