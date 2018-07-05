package com.example.demo.models.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.IParaderoDAO;
import com.example.demo.models.dao.IRutaDAO;
import com.example.demo.models.dao.IRutaParaderoDAO;
import com.example.demo.models.entity.Paradero;
import com.example.demo.models.entity.Ruta;
import com.example.demo.models.entity.RutaParadero;
import com.example.demo.models.entity.RutaParaderoPK;
import com.example.demo.models.service.protocol.IRutaParaderoService;
import com.example.demo.models.service.viewmodel.ParaderoViewModel;
import com.example.demo.models.service.viewmodel.RutaParaderoViewModel;

@Service
public class RutaParaderoService implements IRutaParaderoService {

	@Autowired
	IRutaParaderoDAO rutaParaderoDAO;
	@Autowired
	IRutaDAO rutaDAO;
	@Autowired
	IParaderoDAO paraderoDAO;
	
	@Override
	public RutaParaderoViewModel findRutaParadero(String rutaID){
		RutaParaderoViewModel rutaParaderoMatch = new RutaParaderoViewModel(rutaDAO.findById(rutaID).orElse(new Ruta()));
		List<ParaderoViewModel> matches = new ArrayList<ParaderoViewModel>();
		List<RutaParadero> rutaParaderos = rutaParaderoDAO.findAll().stream().filter(x -> x.getRuta().getRutaID() == rutaID).collect(Collectors.toList());
		for (Paradero paradero: paraderoDAO.findAll()) {
			boolean didMatch = false;
		    for (RutaParadero rutaParadero: rutaParaderos) {
		    	if (rutaParadero.getParadero() == paradero) {
		    		didMatch = true;
		    	}
		    }
		    matches.add(new ParaderoViewModel(paradero,didMatch));
		}
		rutaParaderoMatch.setParaderoMatches(matches);
		return rutaParaderoMatch;
	}
	

	@Override
	public void save(RutaParaderoViewModel t) {
		rutaParaderoDAO.deleteAll();
		rutaDAO.save(t.ruta);
		for (ParaderoViewModel paraderoMatch: t.paraderoMatches) {
			if (paraderoMatch.match == true) {
				System.out.println("true");
				rutaParaderoDAO.save(new RutaParadero(t.ruta.getRutaID(),paraderoMatch.paradero.getParaderoID()));
			}
			else if (rutaParaderoDAO.findById(new RutaParaderoPK(t.ruta.getRutaID(), paraderoMatch.paradero.getParaderoID())).isPresent()){
				System.out.println("false");
				System.out.println(rutaParaderoDAO.findById(new RutaParaderoPK(t.ruta.getRutaID(), paraderoMatch.paradero.getParaderoID())).get().getRuta().getRutaID());
				System.out.println(rutaParaderoDAO.findById(new RutaParaderoPK(t.ruta.getRutaID(), paraderoMatch.paradero.getParaderoID())).get().getParadero().getParaderoID());
				RutaParadero rp = rutaParaderoDAO.findById(new RutaParaderoPK(t.ruta.getRutaID(), paraderoMatch.paradero.getParaderoID())).get();
				rutaParaderoDAO.delete(rp);
			}
		}
	}
	
	@Override
	public Collection<RutaParadero> findAll() {
		// TODO Auto-generated method stub
		return rutaParaderoDAO.findAll();
	}

	@Override
	public void save(RutaParadero t) {
		// TODO Auto-generated method stub
		rutaParaderoDAO.save(t);
	}

	@Override
	public Optional<RutaParadero> findById(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String t) {
		// TODO Auto-generated method stub

	}

	@Override
	public java.util.Map<String, Object> Map() {
		// TODO Auto-generated method stub
		return null;
	}

}
