package com.cg.sbrms.service;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.sbrms.model.TheaterModel;



@FeignClient(name = "theater-service")
@RibbonClient(name ="theater-service")
public interface TheaterProxyService {

		@GetMapping("/theatres/{id}")
		public TheaterModel getTheater(@PathVariable(name="id") long id);
		
		@GetMapping("/theatres/theatre/{theaterName}")
		public List<TheaterModel> getTheaterListByName(@PathVariable("theaterName") String theaterName);
}
