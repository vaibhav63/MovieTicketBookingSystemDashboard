package com.cg.sbrms.controller;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sbrms.entity.ShowEntity;
import com.cg.sbrms.exception.ShowException;
import com.cg.sbrms.model.ShowModel;
import com.cg.sbrms.service.ShowService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/show")
public class ShowController {

	@Autowired
	private ShowService service;
	
	
	@GetMapping
	public ResponseEntity<List<ShowModel>> findAllShows(){
		
		return new ResponseEntity<List<ShowModel>>(service.findAll(),HttpStatus.OK); 
		
	}
	
	@PostMapping
	public ResponseEntity<ShowModel> saveShow(@RequestBody ShowModel model) throws ShowException{
		
		return new ResponseEntity<ShowModel>(service.saveANDupdate(model),HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ShowModel> deleteShow(@PathVariable("id") Long showId) throws ShowException{
		
		return new ResponseEntity<ShowModel>(service.deleteById(showId),HttpStatus.OK);
	}
	
	
	@PutMapping
	public ResponseEntity<ShowModel> updateShow(@RequestBody ShowModel model) throws ShowException{
		
		return new ResponseEntity<ShowModel>(service.saveANDupdate(model),HttpStatus.CREATED);
	}
	
	@GetMapping("/theaterName/{theaterName}")
	public ResponseEntity<List<ShowModel>> findShowByTheaterName(@PathVariable("theaterName") String theaterName) throws ShowException{
		
		return new ResponseEntity<List<ShowModel>>(service.findByTheaterName(theaterName),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/movieName/{movieName}")
	public ResponseEntity<List<ShowModel>> findShowByMovieName(@PathVariable("movieName") String movieName) throws ShowException{
		
		return new ResponseEntity<List<ShowModel>>(service.findByMovieName(movieName),HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/showDate/{showDate}")
	public ResponseEntity<List<ShowModel>> findShowByDate(@PathVariable("showDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate showDate) throws ShowException{
		
		return new ResponseEntity<List<ShowModel>>(service.findByShowDate(showDate),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/onGoingShows")
	public ResponseEntity<List<ShowModel>> findOnGoingShows(){
		
		return new ResponseEntity<>(service.findOnGoingShowList(),HttpStatus.OK);
	}
	

	@GetMapping("/screenId/{id}")
	public ResponseEntity<List<ShowModel>> findShowsByScreenId(@PathVariable("id") Long screenId){
		
		return new ResponseEntity<List<ShowModel>>(service.findShowListByScreenId(screenId),HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/delete/theaterId/{theaterId}")
    public ResponseEntity<Boolean> deleteByTheaterId(@PathVariable("theaterId") Long theaterId) throws ShowException {
		
		service.deleteByTheaterId(theaterId);
		return new ResponseEntity<>(true,HttpStatus.OK);
	
	}
	
	
	
	@DeleteMapping("/delete/screenId/{screenId}")
    public ResponseEntity<Boolean> deleteByScreenId(@PathVariable("screenId") Long screenId) throws ShowException {
		
		service.deleteByScreenId(screenId);
		return new ResponseEntity<>(true,HttpStatus.OK);
	
	}
	
	
	
	
}
