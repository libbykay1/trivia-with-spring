package com.example.triviaSpring.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.triviaSpring.dtos.GameRequestDto;
import com.example.triviaSpring.dtos.GameResponseDto;
import com.example.triviaSpring.dtos.PointsDto;
import com.example.triviaSpring.services.GameService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("game")
public class GameController {
	
	private final GameService gameService;
	
	@GetMapping("{gameId}")
	public GameResponseDto getGame(@PathVariable Long gameId) {
		return gameService.getGame(gameId);
	}
	
	@PostMapping
	public GameResponseDto addGame(@RequestBody GameRequestDto gameRequestDto) {
		return gameService.addGame(gameRequestDto);
	}
	
	@GetMapping("scores/{gameId}")
	public List<PointsDto> getScores(@PathVariable Long gameId) {
		return gameService.getScores(gameId);
	}

}
