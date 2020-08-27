package com.cg.sbrms.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "SHOW_DETAILS")
public class ShowEntity {
	
	
	    @Id
	    @Column(name = "SHOW_ID")
	    private long showId;
	    @Column(name = "THEATER_ID")
	    private long theaterId;
	    @Column(name = "SCREEN_ID")
	    private long screenId;
	    @Column(name = "MOVIE_ID")
	    private long movieId;
	    @Column(name = "MOVIE_NAME")
	    private String movieName;
	    @Column(name = "SHOW_DATE")
	    private LocalDate showDate;
	    @Column(name = "START_TIME")
	    private LocalTime startTime;
	    @Column(name = "END_TIME")
	    private LocalTime endTime;
	    @Column(name = "SHOW_POSTER")
	    private String showPoster;
	    
	    

	
		public long getShowId() {
			return showId;
		}
		public void setShowId(long showId) {
			this.showId = showId;
		}
		public long getTheaterId() {
			return theaterId;
		}
		public void setTheaterId(long theatreId) {
			this.theaterId = theatreId;
		}
		public long getScreenId() {
			return screenId;
		}
		public void setScreenId(long screenId) {
			this.screenId = screenId;
		}
		public long getMovieId() {
			return movieId;
		}
		public void setMovieId(long movieId) {
			this.movieId = movieId;
		}
		public String getMovieName() {
			return movieName;
		}
		public void setMovieName(String movieName) {
			this.movieName = movieName;
		}
		public LocalDate getShowDate() {
			return showDate;
		}
		public void setShowDate(LocalDate showDate) {
			this.showDate = showDate;
		}
		public LocalTime getStartTime() {
			return startTime;
		}
		public void setStartTime(LocalTime startTime) {
			this.startTime = startTime;
		}
		public LocalTime getEndTime() {
			return endTime;
		}
		public void setEndTime(LocalTime endTime) {
			this.endTime = endTime;
		}
		public String getShowPoster() {
			return showPoster;
		}
		public void setShowPoster(String showPoster) {
			this.showPoster = showPoster;
		}
		
	    
	
}
