package com.example.exam.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class MovieUpdateDto {
	
	@NotBlank()
	private String title;
	
	@Min(0)
	private double rating;
}
