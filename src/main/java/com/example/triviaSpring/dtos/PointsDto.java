package com.example.triviaSpring.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PointsDto {
	private String teamName;
	private Double points;
}
