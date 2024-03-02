package com.example.triviaSpring.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.triviaSpring.dtos.QuestionRequestDto;
import com.example.triviaSpring.dtos.QuestionResponseDto;
import com.example.triviaSpring.entities.Question;
import com.example.triviaSpring.services.QuestionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {
	
	private final QuestionService questionService;
	
	@GetMapping
	public List<QuestionResponseDto> getQuestions() {
		return questionService.getQuestions();
	}
	
	@GetMapping("/{id}")
	public QuestionResponseDto getQuestion(@PathVariable Long id) {
		return questionService.getQuestion(id);
	}
	
	@PostMapping
	public QuestionResponseDto addQuestion(@RequestBody QuestionRequestDto questionRequestDto) {
		return questionService.addQuestion(questionRequestDto);
	}
	
	@DeleteMapping("/{id}")
	public QuestionResponseDto deleteQuestion(@PathVariable Long id) {
		return questionService.deleteQuestion(id);
	}
	
	@GetMapping("/round/{id}")
	public List<QuestionResponseDto> getQuestionsByRound(@PathVariable Long id) {
		return questionService.getQuestionsByRound(id);
	}
	
	@PatchMapping("/{id}/{imageUrl}")
	public QuestionResponseDto addImageToQuestion(@PathVariable Long id, @PathVariable String imageUrl) {
		return questionService.addImageToQuestion(id, imageUrl);
	}
}
