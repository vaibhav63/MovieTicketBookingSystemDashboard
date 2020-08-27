package com.cg.oms.service;

import java.util.List;

import com.cg.oms.exception.ScreenException;
import com.cg.oms.model.ScreenModel;
import com.cg.oms.model.ShowModel;


public interface ScreenService {
	
    List<ScreenModel> findAll();
    ScreenModel deleteById(Long screenId) throws ScreenException;
    ScreenModel saveAndupdate(ScreenModel model) throws ScreenException;
	List<ScreenModel> findByTheaterName(String theaterName) throws ScreenException;
    ScreenModel findScreenListByScreenId(Long screenId);
	List<ScreenModel> findByTheaterId(Long theatreId) throws ScreenException;
	void deleteByTheaterId(Long theaterId) throws ScreenException;
	
//	getting showlist from shows
	List<ShowModel>  findShowListByScreenId(Long screenId) throws ScreenException;
		
	
}
