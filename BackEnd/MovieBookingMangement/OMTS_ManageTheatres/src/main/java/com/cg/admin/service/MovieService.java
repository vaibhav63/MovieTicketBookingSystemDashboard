package com.cg.admin.service;

import java.util.List;

import com.cg.admin.entity.Movie;
import com.cg.admin.exception.ResourceNotFoundException;

public interface MovieService {
	public List<Movie> getAllMovies();

	public Movie getMovieById(Long movieId) throws ResourceNotFoundException;
}
