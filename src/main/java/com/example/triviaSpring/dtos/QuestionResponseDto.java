package com.example.triviaSpring.dtos;

import java.util.List;

import com.example.triviaSpring.entities.Round;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionResponseDto {
	
	private Long id;
	
	private String text;
	
	private List<String> acceptableAnswers;
	
	private Double availablePoints;
	
	private Integer numberInRound;
	
	private String imageUrl;
	
	private boolean bonus;

}
