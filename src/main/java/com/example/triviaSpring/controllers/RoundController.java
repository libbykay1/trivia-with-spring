package com.example.triviaSpring.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.triviaSpring.dtos.QuestionResponseDto;
import com.example.triviaSpring.dtos.RoundRequestDto;
import com.example.triviaSpring.dtos.RoundResponseDto;
import com.example.triviaSpring.services.RoundService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/round")
public class RoundController {

	private final RoundService roundService;

	@GetMapping
	public List<RoundResponseDto> getRounds() {
		return roundService.getRounds();
	}

	@GetMapping("/{id}")
	public RoundResponseDto getRound(@PathVariable Long id) {
		return roundService.getRound(id);

	}
	
	@PostMapping
	public RoundResponseDto addRound(@RequestBody RoundRequestDto roundRequestDto) {
		return roundService.addRound(roundRequestDto);
	}
	
	@DeleteMapping("/{id}")
	public RoundResponseDto deleteRound(@PathVariable Long id) {
		return roundService.deleteRound(id);
	}
	
	@PatchMapping("/{id}")
	public RoundResponseDto makeRoundVisible(@PathVariable Long id) {
		return roundService.makeRoundVisible(id);
	}

}
