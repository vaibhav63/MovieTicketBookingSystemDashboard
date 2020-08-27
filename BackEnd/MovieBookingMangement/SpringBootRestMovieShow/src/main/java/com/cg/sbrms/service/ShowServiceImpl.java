package com.cg.sbrms.service;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.sbrms.entity.ShowEntity;
import com.cg.sbrms.exception.ShowException;
import com.cg.sbrms.model.ShowModel;
import com.cg.sbrms.model.TheaterModel;
import com.cg.sbrms.repo.ShowRepository;



@Service
public class ShowServiceImpl implements ShowService {

//3.	add url to variables
	
//	@Value("${screenURL}")
//	private String screenURL;
//	
//	@Value("${movieURL}")
//	private String movieURL;
//	
//	@Value("${theaterURL}")
//	private String theaterURL;
//	
//	
//	@Autowired
//	private RestTemplate rest;
	
	
	@Autowired
	private TheaterProxyService proxy;

	
	@Autowired
	private ShowRepository repo;
	
	public ShowModel of(ShowEntity source) {
		
		ShowModel result=null;
		if(source!=null) {
			result=new ShowModel();
			result.setShowId(source.getShowId());
			result.setMovieName(source.getMovieName());
			result.setShowDate(source.getShowDate());
			result.setStartTime(source.getStartTime());
			result.setEndTime(source.getEndTime());
			result.setShowPoster(source.getShowPoster());
			result.setMovieId(source.getMovieId());
		    result.setTheaterId(source.getTheaterId());
		    result.setScreenId(source.getScreenId());
			
		    TheaterModel theaterModel=proxy.getTheater(source.getTheaterId());
			if(theaterModel!=null) {
				result.setTheaterName(theaterModel.getTheatreName());
			}
		}
		
		return result;
	}
	
	public ShowEntity of(ShowModel source)  {
		
		ShowEntity result=null;
		if(source!=null) {
			result=new ShowEntity();
			result.setShowId(source.getShowId());
			result.setMovieName(source.getMovieName());
			result.setShowDate(source.getShowDate());
			result.setStartTime(source.getStartTime());
			result.setEndTime(source.getEndTime());
		    result.setShowPoster(source.getShowPoster());
		    result.setMovieId(source.getMovieId());
		    result.setTheaterId(source.getTheaterId());
		    result.setScreenId(source.getScreenId());
			
			
		}
		
		return result;
	}
	
	@Override
	public List<ShowModel> findAll() {
		
		
		return repo.findAll().stream()
				.map(entity->
					of(entity)
				).collect(Collectors.toList());
	}

	@Override
	public ShowModel deleteById(Long showId) throws ShowException {
	
		if(showId!=null) {
			
			ShowModel model=of(repo.findById(showId).orElse(null));
			if(model!=null) {
			
				repo.deleteById(showId);
				return model;
				
			}else {
				throw new ShowException("Element does not exist");
			}
		}else {
			throw new ShowException("Id for DEletion is null");
		}
		
		
	}

	@Override
	public ShowModel saveANDupdate(ShowModel model) throws ShowException {
		
		if(model!=null) {
			return of(repo.save(of(model)));
			
		}else {
			
			throw new ShowException("No information to save or update");
		}
		
	}

	@Override
	public List<ShowModel> findByTheaterName(String theaterName) throws ShowException {
		
		List<TheaterModel> theaterModelList= proxy.getTheaterListByName(theaterName);
		List<ShowModel> finalList=new ArrayList<ShowModel>();
		for(TheaterModel theaterModel:theaterModelList) {
			
			finalList.addAll(repo.findByTheaterId(theaterModel.getTheatreID()).stream()
					.map(entity -> of(entity)).collect(Collectors.toList()));
		
		}
		return finalList;
	}

	
	@Override
	public List<ShowModel> findByMovieName(String movieName) throws ShowException {

		if(movieName.equals(null)) {
			throw new ShowException("Movie Name is null");
		}else {
			return repo.findByMovieName(movieName).stream()
				.map(entity->
					of(entity)
				).collect(Collectors.toList());
		}
		
	}

	@Override
	public List<ShowModel> findByShowDate(LocalDate showDate) throws ShowException {
		
		if(showDate==null) {
			throw new ShowException("Show Date is null");
		}else {
			return repo.findByShowDate(showDate).stream()
				.map(entity->
					of(entity)
				).collect(Collectors.toList());
		}
	}

	@Override
	public List<ShowModel> findOnGoingShowList() {
		
		return repo.findOnGoingShows(LocalDate.now(), LocalTime.now()).stream()
				.map(entity ->
				    of(entity))
				.collect(Collectors.toList());
	}

	@Override
	public List<ShowModel> findShowListByScreenId(Long screenId) {
		
		return repo.findShowsByScreenId(screenId).stream()
				.map(entity -> of(entity))
				.collect(Collectors.toList());
	}

	@Override
	public void deleteByTheaterId(Long theaterId) throws ShowException {


		if(theaterId==null) {
			throw new ShowException("cannot delete using theater Id because theater id doesnot exist");
		}else {
			 repo.deleteByTheaterId(theaterId);
		}
		
	}

	@Override
	public void deleteByScreenId(Long screenId) throws ShowException {
	
		

		if(screenId==null) {
			throw new ShowException("cannot delete using screen Id because theater id doesnot exist");
		}else {
			 repo.deleteByScreenId(screenId);
		}
	}

	
	
	
	
}
