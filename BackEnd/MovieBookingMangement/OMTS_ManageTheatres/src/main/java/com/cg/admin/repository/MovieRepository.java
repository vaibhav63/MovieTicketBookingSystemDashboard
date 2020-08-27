package com.cg.admin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.admin.entity.Movie;

@Repository

public interface MovieRepository  extends CrudRepository<Movie, Long>{
}
