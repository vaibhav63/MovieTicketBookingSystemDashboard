package com.cg.oms.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.oms.entity.ScreenEntity;
import com.cg.oms.exception.ScreenException;
import com.cg.oms.model.ScreenModel;
import com.cg.oms.model.ShowModel;
import com.cg.oms.model.TheaterModel;
import com.cg.oms.repo.ScreenRepository;



@Service
public class ScreenServiceImpl implements ScreenService {

//	@Value("${showURL}")
//	private String showURL;
//	
//	@Value("${theaterURL}")
//	private String theaterURL;
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private TheaterProxyService theaterProxy;
	
	@Autowired
	private ShowProxyService showProxy;
	
	@Autowired
	private ScreenRepository repo;
	
	public ScreenModel entityToModel(ScreenEntity source) {
		
		ScreenModel result=null;
		if(source!=null) {
			result=new ScreenModel();
			BeanUtils.copyProperties(source, result);
		}
		
		return result;
	}
	
	public ScreenEntity modelToEntity(ScreenModel source) {
		
		ScreenEntity result=null;
		if(source!=null) {
			result=new ScreenEntity();
			BeanUtils.copyProperties(source, result);
		}
		
		return result;
	}
		
	@Override
	public List<ScreenModel> findAll() {
		return repo.findAll().stream()
				.map(entity->
					entityToModel(entity)
				).collect(Collectors.toList());
	}

	@Override
	public ScreenModel deleteById(Long screenId) throws ScreenException {
	
		if(screenId!=null) {
			
			ScreenModel model=entityToModel(repo.findById(screenId).orElse(null));
			if(model!=null) {
			
				repo.deleteById(screenId);
				return model;
				
			}else {
				throw new ScreenException("Element does not exist");
			}
		}else {
			throw new ScreenException("Id for Deletion is null");
		}
		
		
	}

	@Override
	public ScreenModel saveAndupdate(ScreenModel model) throws ScreenException {
		if(model!=null) {
			ScreenEntity screenEntity = repo.save(modelToEntity(model));
			return entityToModel(screenEntity);
		}else {
			
			throw new ScreenException("No information to save or update");
		}
		
	}

	@Override
	public List<ScreenModel> findByTheaterName(String theaterName) throws ScreenException {
		

		List<TheaterModel> theaterModelList=theaterProxy.getTheaterListByName(theaterName);
		
		List<ScreenModel> finalList=new ArrayList<ScreenModel>();
		for(TheaterModel theaterModel:theaterModelList) {
			
			finalList.addAll(repo.findAllByTheatreId(theaterModel.getTheatreID()).stream()
					.map(entity -> entityToModel(entity)).collect(Collectors.toList()));
		
		}
		return finalList;
	}

	
	@Override
	public List<ScreenModel> findByTheaterId(Long theatreId) throws ScreenException {
		

		

		
		if(theatreId==null) {
			throw new ScreenException("theater Id doesnt exist");
		}else {
			return repo.findAllByTheatreId(theatreId).stream()
				          .map(entity -> entityToModel(entity)).collect(Collectors.toList());
		}
	}
	


	@Override
	public ScreenModel findScreenListByScreenId(Long screenId) {
		
		return entityToModel(repo.findById(screenId).get());
	}

	@Override
	public List<ShowModel> findShowListByScreenId(Long screenId) throws ScreenException {
		
		if(screenId!=null) {
			

			
			List<ShowModel> showModelList=showProxy.getShowListByScreenId(screenId);
			return showModelList;
			
		}else {
			
			throw new ScreenException("Screeen is not valid");
		}
		
		
	}

	@Override
	public void deleteByTheaterId(Long theaterId) throws ScreenException {


		if(theaterId==null) {
			throw new ScreenException("cannot delete using theater Id because theater id doesnot exist");
		}else {
			 repo.deleteByTheatreId(theaterId);
		}
		
	}
}
