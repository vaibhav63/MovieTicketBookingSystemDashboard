package com.cg.oms.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.oms.entity.ScreenEntity;



@Repository
public interface ScreenRepository extends JpaRepository<ScreenEntity, Long> {

	List<ScreenEntity> findByscreenName(String screenName);
	List<ScreenEntity> findAllByTheatreId(long theatreID);
	
	 @Transactional
		@Modifying
		@Query("DELETE  FROM ScreenEntity s WHERE s.theatreId = :theaterId")
	    void deleteByTheatreId(@Param("theaterId") Long theaterId);
}
