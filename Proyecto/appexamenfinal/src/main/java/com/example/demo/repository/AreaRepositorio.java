package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Area;

@Repository
public interface AreaRepositorio extends JpaRepository<Area, Long>{
	
}
