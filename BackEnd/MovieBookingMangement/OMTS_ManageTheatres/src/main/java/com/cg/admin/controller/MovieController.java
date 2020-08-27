package com.cg.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.admin.entity.Movie;
import com.cg.admin.exception.ResourceNotFoundException;
import com.cg.admin.service.MovieService;

@RestController
@CrossOrigin("http://localhost:4200")
public class MovieController {
	
	@Autowired MovieService Mservice;
	
	@GetMapping("/movies")
	public ResponseEntity<List<Movie>> getAllMovies(){
		return ResponseEntity.ok().body(Mservice.getAllMovies());
	}
	
	@GetMapping("/movies/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable Long id) throws ResourceNotFoundException{
		return ResponseEntity.ok().body(Mservice.getMovieById(id));
	}

}
