package com.example.triviaSpring.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.triviaSpring.dtos.PointsDto;
import com.example.triviaSpring.entities.Game;
import com.example.triviaSpring.entities.Team;
import com.example.triviaSpring.services.GameService;
import com.example.triviaSpring.services.RoundService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
	
	private final RoundService roundService;
	@Override
	public List<PointsDto> getScores(Long gameId) {
		Game game = roundService.getGameEntity(gameId);
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
}
