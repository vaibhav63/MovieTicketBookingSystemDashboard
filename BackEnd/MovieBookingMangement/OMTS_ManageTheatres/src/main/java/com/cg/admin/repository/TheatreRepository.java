package com.cg.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.admin.entity.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository< Theatre, Long>{
	
	List<Theatre> findByTheatreName(String theatreName);
}
