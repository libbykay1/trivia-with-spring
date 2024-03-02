package com.example.triviaSpring.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeamResponseDto {
	
	private Long id;
	private String name;
	private Double totalPoints;
	

}
