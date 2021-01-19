package com.example.exam.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exam.dto.CommonDto;
import com.example.exam.dto.MovieSaveDto;
import com.example.exam.dto.MovieUpdateDto;
import com.example.exam.model.Movie;
import com.example.exam.repository.MovieRepository;

@RestController
public class MovieController {

private MovieRepository movieRepository;

public MovieController(MovieRepository movieRepository) {
	this.movieRepository = movieRepository;
}

@GetMapping("/")
public CommonDto<List<Movie>> findAll() {
	System.out.println("영화 리스트 출력()");
	return new CommonDto<>(HttpStatus.OK.value(), movieRepository.findAll()); // MessageConverter (JavaObject -> Json String)
}

@GetMapping("/{id}")
public CommonDto<Movie> findById(@PathVariable int id) {
	System.out.println("영화 하나 출력");
	return new CommonDto<>(HttpStatus.OK.value(), movieRepository.findById(id)); // MessageConverter (JavaObject -> Json String)
}

@PostMapping("/")
public CommonDto<?> save(@Valid @RequestBody MovieSaveDto dto, BindingResult bindingResult) {
	System.out.println("save()");
	System.out.println("user : "+dto);
	
	movieRepository.save(dto);
	
	return new CommonDto<>(HttpStatus.OK.value(), "ok");
}

@DeleteMapping("/{id}")
public CommonDto delete(@PathVariable String id) {
	
	try {
		int deleteId = Integer.parseInt(id);
		movieRepository.delete(deleteId);
		return new CommonDto<>(HttpStatus.OK.value(), "ok");
	} catch (Exception e) {
		System.out.println("에러발생");
		return new CommonDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "fail");
	}

//@PathVariable
// - null체크를 해주지 않는다
// - @PathVariable(required=false)를 사용하면 null체크를 해주는것 같은데 어째서인지 동작하지 않는다.
// - PathVariable은 Valid를 지원해주지 않는다.
 
//시도한방법, 
// 1. instanceof사용
// - 기본자료형은 instanceof를 사용할 수 없다. -> Obejct객체에 담아서 사용해봤다 -> 실패
// 2. 따로 Dto를 하나더 만든다 -> But Delete요청이고 Body데이터가 없기때문에 잘못된 방식 -> 실패
// 3. 그냥 쉽게 String id로 받아서 내부 로직으로 처리하다 에러가나면 넘겨버리는 방식 -> 성공
}

@PutMapping("/{id}")
public CommonDto update(@PathVariable int id,@Valid @RequestBody MovieUpdateDto dto, BindingResult bindingResult) {
	System.out.println("update()");
	movieRepository.update(id, dto);
	return new CommonDto<>(HttpStatus.OK.value(), "ok");
}

}
