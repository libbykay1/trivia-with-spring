package com.example.triviaSpring.services;

import java.util.List;

import com.example.triviaSpring.dtos.QuestionRequestDto;
import com.example.triviaSpring.dtos.QuestionResponseDto;
import com.example.triviaSpring.entities.Question;

public interface QuestionService {

	List<QuestionResponseDto> getQuestions();

	QuestionResponseDto getQuestion(Long id);

	QuestionResponseDto addQuestion(QuestionRequestDto questionRequestDto);

	QuestionResponseDto deleteQuestion(Long id);

	List<QuestionResponseDto> getQuestionsByRound(Long id);

	QuestionResponseDto addImageToQuestion(Long id, String imageUrl);


}
