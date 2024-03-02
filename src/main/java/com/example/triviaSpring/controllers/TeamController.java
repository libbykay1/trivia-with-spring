package com.example.triviaSpring.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.triviaSpring.dtos.PointsDto;
import com.example.triviaSpring.dtos.TeamRequestDto;
import com.example.triviaSpring.dtos.TeamResponseDto;
import com.example.triviaSpring.exceptions.BadRequestException;
import com.example.triviaSpring.services.TeamService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {
	
	private final TeamService teamService;
	
	@PostMapping
	public TeamResponseDto createTeam(@RequestBody TeamRequestDto teamRequestDto) {
		return teamService.createTeam(teamRequestDto);
	}
	
	

}
