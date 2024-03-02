package com.example.triviaSpring.services;

import java.util.List;

import com.example.triviaSpring.dtos.RoundRequestDto;
import com.example.triviaSpring.dtos.RoundResponseDto;
import com.example.triviaSpring.entities.Game;
import com.example.triviaSpring.entities.Round;

public interface RoundService {

	List<RoundResponseDto> getRounds();

	RoundResponseDto getRound(Long id);

	RoundResponseDto addRound(RoundRequestDto roundRequestDto);

	RoundResponseDto deleteRound(Long id);
	
	Round getRoundEntity(Long id);

	RoundResponseDto makeRoundVisible(Long id);

	Game getGameEntity(Long id);

}
