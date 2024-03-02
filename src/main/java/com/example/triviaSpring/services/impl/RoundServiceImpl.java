package com.example.triviaSpring.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.triviaSpring.dtos.QuestionRequestDto;
import com.example.triviaSpring.dtos.RoundRequestDto;
import com.example.triviaSpring.dtos.RoundResponseDto;
import com.example.triviaSpring.entities.Game;
import com.example.triviaSpring.entities.Question;
import com.example.triviaSpring.entities.Round;
import com.example.triviaSpring.exceptions.BadRequestException;
import com.example.triviaSpring.exceptions.NotFoundException;
import com.example.triviaSpring.mappers.GameMapper;
import com.example.triviaSpring.mappers.RoundMapper;
import com.example.triviaSpring.repositories.GameRepository;
import com.example.triviaSpring.repositories.QuestionRepository;
import com.example.triviaSpring.repositories.RoundRepository;
import com.example.triviaSpring.services.RoundService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoundServiceImpl implements RoundService {

	private final RoundMapper roundMapper;
	private final RoundRepository roundRepository;
	private final QuestionRepository questionRepository;
	private final GameRepository gameRepository;
	private final GameMapper gameMapper;
	
	@Override
	public Game getGameEntity(Long id) {
		Optional<Game> game = gameRepository.findByIdAndDeletedFalse(id);
		if(game.isEmpty()) {
			throw new NotFoundException("No game found with id: " + id);
		}
		return game.get();
	}
	

	private void validateRoundRequest(RoundRequestDto roundRequestDto) {
		if (roundRequestDto == null || roundRequestDto.getTitle() == null || roundRequestDto.getRoundNumber() == null
				|| roundRequestDto.getQuestions() == null || roundRequestDto.getCorrectAnswers() == null
				|| roundRequestDto.getDescription() == null || roundRequestDto.getGameId() == null) {
			throw new BadRequestException("All fields are required on a Round request dto");
		}
	}
	
	private void validateQuestionRequest(QuestionRequestDto questionRequestDto) {
		if (questionRequestDto == null || questionRequestDto.getText() == null 
				|| questionRequestDto.getAcceptableAnswers() == null || questionRequestDto.getNumberInRound() == null
				|| questionRequestDto.getAvailablePoints() == null) {
			throw new BadRequestException("All fields are required on a Question request dto");
		}
	}
	
	@Override
	public Round getRoundEntity(Long id) {
		Optional<Round> round = roundRepository.findByIdAndDeletedFalse(id);
		if (round.isEmpty()) {
			throw new NotFoundException("No round found with id: " + id);
		}
		return round.get();
	}

	@Override
	public List<RoundResponseDto> getRounds() {
		return roundMapper.entitiesToDtos(roundRepository.findAllByDeletedFalse());

	}

	@Override
	public RoundResponseDto getRound(Long id) {
		Optional<Round> round = roundRepository.findByIdAndDeletedFalse(id);
		if (round.isEmpty()) {
			throw new NotFoundException("No round found with id: " + id);
		}
		return roundMapper.roundEntityToResponseDto(round.get());
	}

	@Override
	public RoundResponseDto addRound(RoundRequestDto roundRequestDto) {
		validateRoundRequest(roundRequestDto);
		Round round = roundMapper.roundRequestDtoToEntity(roundRequestDto);
		if (!roundRequestDto.getQuestions().isEmpty()) {
			for (QuestionRequestDto questionRequestDto : roundRequestDto.getQuestions()) {
				validateQuestionRequest(questionRequestDto);
				questionRequestDto.setRoundId(round.getId());
			}
		}
		
		round.setDeleted(false);
		round.setVisible(false);
		round.setGame(getGameEntity(roundRequestDto.getGameId()));
		roundRepository.saveAndFlush(round);
		for (Question question : round.getQuestions()) {
			question.setRound(round);
			question.setDeleted(false);
			questionRepository.saveAndFlush(question);
		}

		return roundMapper.roundEntityToResponseDto(round);
	}

	@Override
	public RoundResponseDto deleteRound(Long id) {
		Round roundToDelete = getRoundEntity(id);
		roundToDelete.setDeleted(true);
		if (roundToDelete.getQuestions().size() > 0) {
			for (Question questionToDelete : roundToDelete.getQuestions()) {
				questionToDelete.setDeleted(true);
				questionRepository.saveAndFlush(questionToDelete);
			}
		}
		return roundMapper.roundEntityToResponseDto(roundRepository.saveAndFlush(roundToDelete));
	}

	@Override
	public RoundResponseDto makeRoundVisible(Long id) {
		Round round = getRoundEntity(id);
		round.setVisible(true);
		return roundMapper.roundEntityToResponseDto(roundRepository.saveAndFlush(round));
	}

}
