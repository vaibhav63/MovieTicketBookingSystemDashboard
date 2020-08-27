package com.cg.sbrms.repo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.sbrms.entity.ShowEntity;


@Repository
public interface ShowRepository extends JpaRepository<ShowEntity, Long> {

	List<ShowEntity> findByMovieName(String movieName);
	List<ShowEntity> findByShowDate(LocalDate showDate);
	List<ShowEntity> findByTheaterId(Long theaterId);
	
	@Query("SELECT s FROM ShowEntity s WHERE s.showDate = :currentDate and :currentTime BETWEEN s.startTime AND s.endTime ")
	List<ShowEntity> findOnGoingShows(@Param("currentDate") LocalDate currentDate ,@Param("currentTime") LocalTime currentTime);


	@Query("SELECT s FROM ShowEntity s WHERE s.screenId = :screenId")
	List<ShowEntity> findShowsByScreenId(@Param("screenId") Long screenId);
	
    @Transactional
	@Modifying
	@Query("DELETE  FROM ShowEntity s WHERE s.theaterId = :theaterId")
    void deleteByTheaterId(@Param("theaterId") Long theaterId);
	 
    
    @Transactional
	@Modifying
	@Query("DELETE  FROM ShowEntity s WHERE s.screenId = :screenId")
	 void deleteByScreenId(@Param("screenId") Long screenId);
	
}
