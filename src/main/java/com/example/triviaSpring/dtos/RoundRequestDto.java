package com.example.triviaSpring.dtos;

import java.sql.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.triviaSpring.dtos.QuestionRequestDto;
import com.example.triviaSpring.entities.Question;

@Data
@NoArgsConstructor
public class RoundRequestDto {
	
	private Integer roundNumber;
	
	private String title;
	
	private String description;
	
	private List<QuestionRequestDto> questions;
	
	private List<String> correctAnswers;
	
	private boolean visible;
	
	private Long gameId;
	
	private boolean deleted;

}
