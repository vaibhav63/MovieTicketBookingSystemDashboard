package com.cg.admin.service;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.admin.entity.Theatre;
import com.cg.admin.exception.ResourceNotFoundException;
import com.cg.admin.repository.TheatreRepository;


@Service
@Transactional
public class TheatreServiceImpl implements TheatreService {
	
	@Autowired
	private TheatreRepository repository;

	@Override
	public Theatre createTheatre(Theatre theatre) {
		return repository.save(theatre);
	}

	@Override
	public Theatre updateTheatre(Theatre theatre) throws ResourceNotFoundException {
		Optional<Theatre> theatreOB=this.repository.findById(theatre.getTheatreID());
		
		if(theatreOB.isPresent()) {
			Theatre theatreUpdate=theatreOB.get();
			theatreUpdate.setManagerContact(theatre.getManagerContact());
			theatreUpdate.setManagerName(theatre.getManagerName());
			theatreUpdate.setTheatreCity(theatre.getTheatreCity());
			theatreUpdate.setTheatreID(theatre.getTheatreID());
			theatreUpdate.setTheatreName(theatre.getTheatreName());
			repository.save(theatreUpdate);
			return theatreUpdate;
		}else {
			throw new ResourceNotFoundException("Theatre not found with id:"+theatre.getTheatreID());
		}
	}

	@Override
	public List<Theatre> getAllTheatres() {
		return this.repository.findAll();
	}

	@Override
	public Theatre getTheatreById(Long theatreId) throws ResourceNotFoundException {
		Optional<Theatre> theatreDb= this.repository.findById(theatreId);
		if(theatreDb.isPresent()) {
			return theatreDb.get();
		}
		else {
			throw new ResourceNotFoundException("Theatre not Found with theatre ID"+theatreId);
		}
	}

	@Override
	public void deleteTheatre(Long id) throws ResourceNotFoundException {
		Optional<Theatre> theatreDb=this.repository.findById(id);
		if(theatreDb.isPresent())
		{
			this.repository.delete(theatreDb.get());
		}
		else {
			throw new ResourceNotFoundException("Theatre not found with theatreID"+id);
		}
		
	}

	@Override
	public List<Theatre> findByTheatreName(String theatreName) {
	
		return repository.findByTheatreName(theatreName);
	}


}