package com.example.triviaSpring.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeamRequestDto {
	
	private String name;
	
	private Long gameId;

}
