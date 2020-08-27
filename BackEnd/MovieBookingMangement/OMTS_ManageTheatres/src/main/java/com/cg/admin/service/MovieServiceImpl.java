package com.cg.admin.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.admin.entity.Movie;
import com.cg.admin.exception.ResourceNotFoundException;
import com.cg.admin.repository.MovieRepository;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	
	@Override
	public List<Movie> getAllMovies() {
		return (List<Movie>) this.movieRepository.findAll();
	}

	@Override
	public Movie getMovieById(Long movieId) throws ResourceNotFoundException {
		Optional<Movie> movieDb= this.movieRepository.findById(movieId);
		if(movieDb.isPresent()) {
			return movieDb.get();
		}
		else {
			throw new ResourceNotFoundException("Movie not Found with Movie ID"+movieId);
		}
	}
	

}
