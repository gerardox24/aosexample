package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Area;

public interface IAreaServicio {
	
	public List<Area> findAll();
	
	public void save(Area area);
	
	public Area findById(Long id);
	
	public void deleteById(Long id);
}
