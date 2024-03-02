package com.example.triviaSpring.dtos;

import java.sql.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GameResponseDto {
	private Long id;
	private Date date;
	private List<TeamResponseDto> teams;
	private List<RoundResponseDto> rounds;
}
