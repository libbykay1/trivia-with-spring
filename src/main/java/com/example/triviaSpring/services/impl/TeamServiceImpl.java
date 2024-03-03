package com.example.triviaSpring.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.triviaSpring.dtos.TeamRequestDto;
import com.example.triviaSpring.dtos.TeamResponseDto;
import com.example.triviaSpring.entities.Team;
import com.example.triviaSpring.exceptions.BadRequestException;
import com.example.triviaSpring.exceptions.NotFoundException;
import com.example.triviaSpring.mappers.TeamMapper;
import com.example.triviaSpring.repositories.TeamRepository;
import com.example.triviaSpring.services.RoundService;
import com.example.triviaSpring.services.TeamService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

	private final TeamMapper teamMapper;
	private final TeamRepository teamRepository;
	private final RoundService roundService;

	private void validateTeamRequest(TeamRequestDto teamRequestDto) {
		if (teamRequestDto == null || teamRequestDto.getName() == null) {
			throw new BadRequestException("Name is required to create a team.");
		}

	}

	@Override
	public TeamResponseDto createTeam(TeamRequestDto teamRequestDto) {
		validateTeamRequest(teamRequestDto);
		Team team = teamMapper.requestDtoToEntity(teamRequestDto);

		return teamMapper.entityToResponseDto(teamRepository.saveAndFlush(team));
	}

	@Override
	public Team getTeamEntity(Long id) {
		Optional<Team> team = teamRepository.findByIdAndDeletedFalse(id);
		if (team.isEmpty()) {
			throw new NotFoundException("No team found with id: " + id);
		}
		return team.get();
	}

}
