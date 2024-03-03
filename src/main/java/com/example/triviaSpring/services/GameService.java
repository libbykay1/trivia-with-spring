package com.example.triviaSpring.services;

import java.util.List;

import com.example.triviaSpring.dtos.GameRequestDto;
import com.example.triviaSpring.dtos.GameResponseDto;
import com.example.triviaSpring.dtos.PointsDto;
import com.example.triviaSpring.entities.Game;

public interface GameService {

	Game getGameEntity(Long id);

	GameResponseDto getGame(Long gameId);

	List<PointsDto> getScores(Long gameId);

	GameResponseDto addGame(GameRequestDto gameRequestDto);

}
