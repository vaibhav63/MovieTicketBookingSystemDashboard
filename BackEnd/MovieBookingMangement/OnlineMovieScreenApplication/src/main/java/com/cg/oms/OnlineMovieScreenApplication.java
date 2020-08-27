package com.cg.oms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients("com.cg.oms.service")
@EnableDiscoveryClient

/***
 * 
 * @author UtkarshGoyal
 *
 */
public class OnlineMovieScreenApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineMovieScreenApplication.class, args);
	}

//	2. create rest template
//	@Bean
//	public RestTemplate getTemplate() {
//		return new RestTemplate();
//	}
//	
}
