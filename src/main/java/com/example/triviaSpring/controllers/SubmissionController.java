package com.example.triviaSpring.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.triviaSpring.dtos.SubmissionRequestDto;
import com.example.triviaSpring.dtos.SubmissionResponseDto;
import com.example.triviaSpring.dtos.WrongAnswersDto;
import com.example.triviaSpring.services.SubmissionService;

import lombok.RequiredArgsConstructor;

public @RestController
@RequiredArgsConstructor
@RequestMapping("/submission")
class SubmissionController {
	
	private final SubmissionService submissionService;
	
	@PostMapping("{roundId}")
	public SubmissionResponseDto createSubmission(@PathVariable Long roundId, @RequestBody SubmissionRequestDto submissionRequestDto) {
		return submissionService.createSubmission(roundId, submissionRequestDto);
	}
	
	@GetMapping("wrong/{roundId}")
	public List<WrongAnswersDto> getWrongAnswers(@PathVariable Long roundId) {
		return submissionService.getWrongAnswers(roundId);
	}

}
