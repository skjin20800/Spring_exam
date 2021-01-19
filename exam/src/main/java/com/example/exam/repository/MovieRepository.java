package com.example.exam.repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.exam.dto.MovieSaveDto;
import com.example.exam.dto.MovieUpdateDto;
import com.example.exam.model.Movie;

@Repository
public class MovieRepository {
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	public List<Movie> findAll(){
		List<Movie> movies = new ArrayList<>();
		
		movies.add(new Movie(1, "영화1", 1.0, timestamp ));
		movies.add(new Movie(2, "영화2", 2.0, timestamp ));
		movies.add(new Movie(3, "영화3", 3.0, timestamp ));
		movies.add(new Movie(4, "영화4", 4.0, timestamp ));
		movies.add(new Movie(5, "영화5", 5.0, timestamp ));
		movies.add(new Movie(6, "영화6", 6.0, timestamp ));
		movies.add(new Movie(7, "영화7", 7.0, timestamp ));
		movies.add(new Movie(8, "영화8", 8.0, timestamp ));
		
return movies;
	}
	
	public Movie findById(int id) {
		return new Movie(8, "영화8", 8.0, timestamp);
	}
	
	public void save(MovieSaveDto dto) {
		System.out.println("DB에 insert하기");
	}
	
	public void delete(int id) {
		System.out.println("DB에 삭제하기");
	}
	public void update(int id , MovieUpdateDto dto) {
		System.out.println("DB에 업데이트하기");
	}
	
}
