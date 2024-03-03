package com.example.triviaSpring.controllers;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.triviaSpring.dtos.TeamRequestDto;
import com.example.triviaSpring.dtos.TeamResponseDto;
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
	
	@PatchMapping("{teamId}/addpoint")
	public void addPoint(@PathVariable Long teamId) {
		teamService.addPoint(teamId);
	}

}
