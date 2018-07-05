package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Area;
import com.example.demo.repository.AreaRepositorio;

@Service
public class AreaServicio implements IAreaServicio {
	
	@Autowired
	private AreaRepositorio areaRepositorio;
	
	@Override
	@Transactional(readOnly = true)
	public List<Area> findAll() {
		return (List<Area>) areaRepositorio.findAll();
	}
	
	@Override
	@Transactional
	public void save(Area area) {
		areaRepositorio.save(area);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Area findById(Long id) {
		return areaRepositorio.findOne(id);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		areaRepositorio.delete(id);
	}
}
