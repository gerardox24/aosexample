package com.example.demo.models.service.viewmodel;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.entity.Ruta;
import com.example.demo.models.service.viewmodel.ParaderoViewModel;;

public class RutaParaderoViewModel{
	public Ruta ruta;
	public List<ParaderoViewModel> paraderoMatches;
	
	public RutaParaderoViewModel(Ruta ruta) {
		this.ruta = ruta;
		this.paraderoMatches = new ArrayList<>();
	}
	
	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	public List<ParaderoViewModel> getParaderoMatches() {
		return paraderoMatches;
	}
	public void setParaderoMatches(List<ParaderoViewModel> paraderoMatches) {
		this.paraderoMatches = paraderoMatches;
	}
}
