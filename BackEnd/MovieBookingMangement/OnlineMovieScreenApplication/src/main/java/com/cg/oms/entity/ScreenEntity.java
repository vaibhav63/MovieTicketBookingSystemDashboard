package com.cg.oms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "screen")
public class ScreenEntity{
    
	@Id
	@Column(name = "screen_id")
    private Long screenId;
	
	@Column(name = "screen_name")
    private String screenName;
    
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "movie_end_date")
	private LocalDate movieEndDate;

    @Column(name = "screen_rows")
    private Integer rows;
    
	@Column(name = "screen_columns")
    private Integer columns;
	
	@Column(name = "theatre_id")
	private Long theatreId;

    public Long getScreenId() {
        return screenId;
    }
    public void setScreenId(Long screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}


	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	public Integer getColumns() {
		return columns;
	}

	public void setColumns(Integer columns) {
		this.columns = columns;
	}
	public LocalDate getMovieEndDate() {
		return movieEndDate;
	}
	public void setMovieEndDate(LocalDate movieEndDate) {
		this.movieEndDate = movieEndDate;
	}
	public Long getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(Long theatreId) {
		this.theatreId = theatreId;
	}
}
