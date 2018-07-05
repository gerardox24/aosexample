package com.example.demo.models.service.protocol;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import com.example.demo.models.entity.RutaParadero;
import com.example.demo.models.service.viewmodel.RutaParaderoViewModel;

public interface IRutaParaderoService {
	public Collection<RutaParadero> findAll();

	public void save(RutaParadero t);

	public Optional<RutaParadero> findById(String t);

	public void deleteById(String t);

	public Map<String, Object> Map();

	public RutaParaderoViewModel findRutaParadero(String rutaID);
	
	public void save(RutaParaderoViewModel t);
	
	
}
