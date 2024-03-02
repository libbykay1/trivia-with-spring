package com.example.triviaSpring.dtos;

import java.util.List;

import com.example.triviaSpring.entities.Round;
import com.example.triviaSpring.entities.Team;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubmissionResponseDto {

	private Long id;
	private TeamResponseDto team;
	private RoundResponseDto round;
	private List<String> answers;
	private boolean doubleOrNothing;
	private Double points;
}
