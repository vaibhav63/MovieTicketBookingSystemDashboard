package com.cg.admin.service;

import java.util.List;

import com.cg.admin.entity.Theatre;
import com.cg.admin.exception.ResourceNotFoundException;

public interface TheatreService {
	
	public Theatre createTheatre(Theatre theatre);

	public Theatre updateTheatre(Theatre theatre) throws ResourceNotFoundException;

	public List<Theatre> getAllTheatres();

	public Theatre getTheatreById(Long theatreId) throws ResourceNotFoundException;

	void deleteTheatre(Long id) throws ResourceNotFoundException;
	
	List<Theatre> findByTheatreName(String theatreName);
}
