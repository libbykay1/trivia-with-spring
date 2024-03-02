package com.example.triviaSpring.services;

import java.util.List;

import com.example.triviaSpring.dtos.SubmissionRequestDto;
import com.example.triviaSpring.dtos.SubmissionResponseDto;
import com.example.triviaSpring.dtos.WrongAnswersDto;

public interface SubmissionService {

	SubmissionResponseDto createSubmission(Long teamId, Long roundId, SubmissionRequestDto submissionRequestDto);

	List<WrongAnswersDto> getWrongAnswers(Long roundId);

}
