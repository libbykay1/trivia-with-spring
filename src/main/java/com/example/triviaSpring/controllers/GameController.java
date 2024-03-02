package com.example.triviaSpring.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.triviaSpring.dtos.PointsDto;
import com.example.triviaSpring.services.GameService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("game")
public class GameController {
	
	private final GameService gameService;
	
	@GetMapping("scores/{gameId}")
	public List<PointsDto> getScores(@PathVariable Long gameId) {
		return gameService.getScores(gameId);
	}

}
