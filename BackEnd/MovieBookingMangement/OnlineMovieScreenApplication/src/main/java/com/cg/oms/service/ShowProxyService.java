package com.cg.oms.service;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.oms.model.ShowModel;
import com.cg.oms.model.TheaterModel;





@FeignClient(name = "show-service")
@RibbonClient(name ="show-service")
public interface ShowProxyService {

		@GetMapping("/show/screenId/{id}")
		public List<ShowModel> getShowListByScreenId(@PathVariable(name="id") long id);
		
		
}
