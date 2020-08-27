package com.cg.oms.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.cg.oms.exception.ScreenException;
import com.cg.oms.model.ScreenModel;
import com.cg.oms.model.ShowModel;
import com.cg.oms.service.ScreenService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/screen")
public class ScreenController {

	@Autowired
	private ScreenService service;
	
	
	@GetMapping
	public ResponseEntity<List<ScreenModel>> findAllScreen(){
		
		return new ResponseEntity<List<ScreenModel>>(service.findAll(),HttpStatus.OK); 
		
	}
	
	@PostMapping
	public ResponseEntity<ScreenModel> saveScreen(@RequestBody ScreenModel model) throws ScreenException{
//		model.setScreenId(new Random().nextInt(100) * 10000 + model.getTheatreId());
		return new ResponseEntity<ScreenModel>(service.saveAndupdate(model),HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ScreenModel> deleteScreen(@PathVariable("id") Long screenId) throws ScreenException{
		
		return new ResponseEntity<ScreenModel>(service.deleteById(screenId),HttpStatus.OK);
	}
	
	
	@PutMapping
	public ResponseEntity<ScreenModel> updateScreen(@RequestBody ScreenModel model) throws ScreenException{
		
		return new ResponseEntity<ScreenModel>(service.saveAndupdate(model),HttpStatus.CREATED);
	}
	
	@GetMapping("/theaterName/{theaterName}")
	public ResponseEntity<List<ScreenModel>> findScreenByTheaterName(@PathVariable("theaterName") String theaterName) throws ScreenException{
		
		return new ResponseEntity<List<ScreenModel>>(service.findByTheaterName(theaterName),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/theaterId/{theatreId}")
	public ResponseEntity<List<ScreenModel>> findScreenByTheaterId(@PathVariable("theatreId") Long theatreId) throws ScreenException{
		
		return new ResponseEntity<List<ScreenModel>>(service.findByTheaterId(theatreId),HttpStatus.ACCEPTED);
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<ScreenModel> findScreenByScreenId(@PathVariable("id") Long screenId){
		return new ResponseEntity<ScreenModel>(service.findScreenListByScreenId(screenId),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/showList/screenId/{id}")
	public ResponseEntity<List<ShowModel>> findShowListByScreenId(@PathVariable("id") Long screenId ) throws ScreenException{
		
		return new ResponseEntity<>(service.findShowListByScreenId(screenId),HttpStatus.OK);
	}
	

	
	@DeleteMapping("/delete/theaterId/{theaterId}")
    public ResponseEntity<Boolean> deleteByTheaterId(@PathVariable("theaterId") Long theaterId) throws ScreenException {
		
		service.deleteByTheaterId(theaterId);
		return new ResponseEntity<>(true,HttpStatus.OK);
	
	}
	
}
