package com.cg.sbrms.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.sbrms.entity.ShowEntity;
import com.cg.sbrms.exception.ShowException;
import com.cg.sbrms.model.ShowModel;

public interface ShowService {

	
	
    List<ShowModel> findAll();
	ShowModel deleteById(Long showId) throws ShowException;
	ShowModel saveANDupdate(ShowModel model) throws ShowException;
	List<ShowModel> findByTheaterName(String theaterName) throws ShowException;
	List<ShowModel> findByMovieName(String movieName) throws ShowException;
	List<ShowModel> findByShowDate(LocalDate showDate) throws ShowException;
    List<ShowModel> findOnGoingShowList();
    List<ShowModel> findShowListByScreenId(Long screenId);
    void deleteByTheaterId(Long theaterId) throws ShowException;
    void deleteByScreenId(Long screenId) throws ShowException;
    
}
