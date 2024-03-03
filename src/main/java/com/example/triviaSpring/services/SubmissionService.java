package com.example.triviaSpring.services;

import java.util.List;

import com.example.triviaSpring.dtos.SubmissionRequestDto;
import com.example.triviaSpring.dtos.SubmissionResponseDto;
import com.example.triviaSpring.dtos.WrongAnswersDto;

public interface SubmissionService {

	List<WrongAnswersDto> getWrongAnswers(Long roundId);

	SubmissionResponseDto createSubmission(Long roundId, SubmissionRequestDto submissionRequestDto);

}
