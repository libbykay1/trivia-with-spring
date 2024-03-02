package com.example.triviaSpring.services;

import java.util.List;

import com.example.triviaSpring.dtos.PointsDto;

public interface GameService {
	
	List<PointsDto> getScores(Long gameId);

}
