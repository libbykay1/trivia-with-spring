package com.example.triviaSpring.dtos;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoundRequestDto {

	private String title;

	private String description;

	private List<QuestionRequestDto> questions;

	private List<String> correctAnswers;

	private Long gameId;



}
