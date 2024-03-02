package com.example.triviaSpring.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.triviaSpring.dtos.QuestionRequestDto;
import com.example.triviaSpring.mappers.QuestionMapper;
import com.example.triviaSpring.mappers.RoundMapper;
import com.example.triviaSpring.repositories.QuestionRepository;
import com.example.triviaSpring.repositories.RoundRepository;
import com.example.triviaSpring.services.QuestionService;
import com.example.triviaSpring.services.RoundService;
import com.example.triviaSpring.dtos.QuestionResponseDto;
import com.example.triviaSpring.exceptions.BadRequestException;
import com.example.triviaSpring.exceptions.NotFoundException;
import com.example.triviaSpring.entities.Question;
import com.example.triviaSpring.entities.Round;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
	private final QuestionMapper questionMapper;
	private final QuestionRepository questionRepository;
	private final RoundRepository roundRepository;
	private final RoundService roundService;
	private final RoundMapper roundMapper;
	
	
	private void validateQuestionRequest(QuestionRequestDto questionRequestDto) {
		if (questionRequestDto == null || questionRequestDto.getText() == null || questionRequestDto.getRoundId() == null
				|| questionRequestDto.getAcceptableAnswers() == null || questionRequestDto.getNumberInRound() == null
				|| questionRequestDto.getAvailablePoints() == null) {
			throw new BadRequestException("All fields are required on a Question request dto");
		}
	}
	
	private Question getQuestionEntity(Long id) {
		Optional<Question> question = questionRepository.findByIdAndDeletedFalse(id);
		if (question.isEmpty()) {
			throw new NotFoundException("No question found with id: " + id);
		}
		return question.get();
	}

	@Override
	public List<QuestionResponseDto> getQuestions() {
		return questionMapper.entitiesToDtos(questionRepository.findAllByDeletedFalse());

	}

	@Override
	public QuestionResponseDto getQuestion(Long id) {
		Optional<Question> question = questionRepository.findByIdAndDeletedFalse(id);
		if (question.isEmpty()) {
			throw new NotFoundException("No question found with id: " + id);
		}
		return questionMapper.entityToResponseDto(question.get());
	}

	@Override
	public QuestionResponseDto addQuestion(QuestionRequestDto questionRequestDto) {
		validateQuestionRequest(questionRequestDto);
		Question question = questionMapper.requestDtoToEntity(questionRequestDto);
		question.setRound(roundService.getRoundEntity(questionRequestDto.getRoundId()));
		question.setDeleted(false);
		return questionMapper.entityToResponseDto(questionRepository.saveAndFlush(question));
	}

	@Override
	public QuestionResponseDto deleteQuestion(Long id) {
		Question questionToDelete = getQuestionEntity(id);
		Round round = questionToDelete.getRound();
		questionToDelete.setDeleted(true);
		questionToDelete.setRound(null);
		return questionMapper.entityToResponseDto(questionRepository.saveAndFlush(questionToDelete));
	}

	@Override
	public List<QuestionResponseDto> getQuestionsByRound(Long id) {
		Round round = roundService.getRoundEntity(id);
		return questionMapper.entitiesToDtos(round.getQuestions());
	}

	@Override
	public QuestionResponseDto addImageToQuestion(Long id, String imageUrl) {
		Question question = getQuestionEntity(id);
		question.setImageUrl(imageUrl);
		return questionMapper.entityToResponseDto(questionRepository.saveAndFlush(question));
	}
	


}
