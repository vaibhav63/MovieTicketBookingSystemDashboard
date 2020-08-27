package com.cg.admin.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Movies")
public class Movie {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long movieId;
		
		@Column(name = "movie_Name",nullable = false)
		private String movieName;
		
		@Column(name = "movie_Genre",nullable = false)
		private String movieGenre;
		
		@Column(name = "movie_Director",nullable = false)
		private String movieDirector;
		
		@Column(name = "movie_Length",nullable = false)
		private String movieLength;
		
		@Column(name = "Release_Date",nullable = false)
		private LocalDate movieReleaseDate;

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

		public String getMovieGenre() {
			return movieGenre;
		}

		public void setMovieGenre(String movieGenre) {
			this.movieGenre = movieGenre;
		}

		public String getMovieDirector() {
			return movieDirector;
		}

		public void setMovieDirector(String movieDirector) {
			this.movieDirector = movieDirector;
		}

		public String getMovieLength() {
			return movieLength;
		}

		public void setMovieLength(String movieLength) {
			this.movieLength = movieLength;
		}

		public LocalDate getMovieReleaseDate() {
			return movieReleaseDate;
		}

		public void setMovieReleaseDate(LocalDate movieReleaseDate) {
			this.movieReleaseDate = movieReleaseDate;
		}
}
