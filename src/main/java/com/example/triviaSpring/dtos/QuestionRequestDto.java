package com.example.triviaSpring.dtos;

import java.util.List;

import com.example.triviaSpring.entities.Round;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionRequestDto {

	private Long roundId;

	private String text;

	private List<String> acceptableAnswers;

	private Double availablePoints;

	private Integer numberInRound;

	private boolean deleted;
	
	private boolean bonus;
	
	
	
	
	
	
}
