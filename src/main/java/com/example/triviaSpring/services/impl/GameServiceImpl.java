package com.example.triviaSpring.services.impl;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.triviaSpring.dtos.GameRequestDto;
import com.example.triviaSpring.dtos.GameResponseDto;
import com.example.triviaSpring.dtos.PointsDto;
import com.example.triviaSpring.entities.Game;
import com.example.triviaSpring.entities.Team;
import com.example.triviaSpring.exceptions.NotFoundException;
import com.example.triviaSpring.mappers.GameMapper;
import com.example.triviaSpring.repositories.GameRepository;
import com.example.triviaSpring.services.GameService;
import com.example.triviaSpring.services.RoundService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

	private final GameMapper gameMapper;
	private final GameRepository gameRepository;

	@Override
	public Game getGameEntity(Long id) {
		Optional<Game> game = gameRepository.findByIdAndDeletedFalse(id);
		if (game.isEmpty()) {
			throw new NotFoundException("No game found with id: " + id);
		}
		return game.get();
	}

	@Override
	public GameResponseDto getGame(Long gameId) {
		return gameMapper.entityToDto(getGameEntity(gameId));
	}

	@Override
	public List<PointsDto> getScores(Long gameId) {
		Game game = getGameEntity(gameId);
		List<PointsDto> scores = new ArrayList<>();
		List<Team> teams = game.getTeams();
		for (Team team : teams) {
			PointsDto score = new PointsDto();
			score.setTeamName(team.getName());
			score.setPoints(team.getTotalPoints());
			scores.add(score);
		}
		return scores;
	}

	@Override
	public GameResponseDto addGame(GameRequestDto gameRequestDto) {
	    LocalDateTime localDateTime = gameRequestDto.getDate();


	    
	    Game game = gameMapper.dtoToEntity(gameRequestDto);
	    game.setDate(localDateTime);

	    // Save and return the game response DTO
	    return gameMapper.entityToDto(gameRepository.saveAndFlush(game));
	}

}
