package com.example.triviaSpring.dtos;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WrongAnswersDto {
	private String teamName;
	private List<String> wrongAnswers;
}
