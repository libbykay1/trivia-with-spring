package com.example.triviaSpring.services;

import com.example.triviaSpring.dtos.TeamRequestDto;
import com.example.triviaSpring.dtos.TeamResponseDto;
import com.example.triviaSpring.entities.Team;

public interface TeamService {

	TeamResponseDto createTeam(TeamRequestDto teamRequestDto);

	Team getTeamEntity(Long id);

	

}
