package com.example.triviaSpring.dtos;

import java.sql.Date;
import java.util.List;

import com.example.triviaSpring.entities.Question;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoundResponseDto {
	
	private Long id;

	private Integer roundNumber;

	private String title;

	private String description;

	private List<QuestionResponseDto> questions;

	private List<String> correctAnswers;

	private boolean visible;



}
