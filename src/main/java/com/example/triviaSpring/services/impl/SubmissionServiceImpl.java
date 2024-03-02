package com.example.triviaSpring.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.triviaSpring.dtos.SubmissionRequestDto;
import com.example.triviaSpring.dtos.SubmissionResponseDto;
import com.example.triviaSpring.dtos.WrongAnswersDto;
import com.example.triviaSpring.entities.Game;
import com.example.triviaSpring.entities.Question;
import com.example.triviaSpring.entities.Round;
import com.example.triviaSpring.entities.Submission;
import com.example.triviaSpring.entities.Team;
import com.example.triviaSpring.mappers.SubmissionMapper;
import com.example.triviaSpring.mappers.TeamMapper;
import com.example.triviaSpring.repositories.SubmissionRepository;
import com.example.triviaSpring.services.RoundService;
import com.example.triviaSpring.services.SubmissionService;
import com.example.triviaSpring.services.TeamService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubmissionServiceImpl implements SubmissionService {

	private final SubmissionMapper submissionMapper;
	private final RoundService roundService;
	private final TeamService teamService;
	private final SubmissionRepository submissionRepository;
	private final TeamMapper teamMapper;

	@Override
	public SubmissionResponseDto createSubmission(Long teamId, Long roundId,
			SubmissionRequestDto submissionRequestDto) {
		Submission submission = submissionMapper.requestDtoToEntity(submissionRequestDto);
		Team team = teamService.getTeamEntity(teamId);
		Round round = roundService.getRoundEntity(roundId);
		List<Question> questions = round.getQuestions();
		List<String> submittedAnswers = submission.getAnswers();
		submission.setTeam(team);
		submission.setRound(round);
		submission.setDeleted(false);
		Double pointsEarned = 0.0;
		int correctAnswers = 0;
		for (int i = 0; i < questions.size(); i++) {
			Double points = questions.get(i).getAvailablePoints();
			List<String> acceptableAnswers = questions.get(i).getAcceptableAnswers();
			if (verifyAnswer(submittedAnswers.get(i), acceptableAnswers)) {
				pointsEarned += points;
				correctAnswers += 1;

			}
		}
		if (submission.getDoubleOrNothing() && correctAnswers == questions.size()) {
			pointsEarned *= 2;
		}
		submission.setPoints(pointsEarned);
		team.setTotalPoints(team.getTotalPoints() + pointsEarned);
		return submissionMapper.entityToResponseDto(submissionRepository.saveAndFlush(submission));
	}
	
	

	private boolean verifyAnswer(String submittedAnswer, List<String> acceptableAnswers) {
		for (int i = 0; i < acceptableAnswers.size(); i++) {
			if (submittedAnswer.toLowerCase().contains(acceptableAnswers.get(i).toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<WrongAnswersDto> getWrongAnswers(Long roundId) {
		List<WrongAnswersDto> result = new ArrayList<>();
		Round round = roundService.getRoundEntity(roundId);
		List <Submission> submissions = round.getSubmissions();
		List<Question> questions = round.getQuestions();
		for (Submission submission : submissions) {
			Team team = submission.getTeam();
			WrongAnswersDto wrongAnswersDto = new WrongAnswersDto();
			wrongAnswersDto.setTeamName(team.getName());
			List<String> submittedAnswers = submission.getAnswers();
			List<String> wrongAnswers = new ArrayList<>();
			for (int i = 0; i < questions.size(); i++) {
				Question question = questions.get(i);
				List<String> acceptableAnswers = question.getAcceptableAnswers();
				String answer = submittedAnswers.get(i);
				if (!verifyAnswer(answer, acceptableAnswers) && !answer.equals("")) {
				
					wrongAnswers.add(question.getNumberInRound().toString() + ". " + answer);
				}
			}
			wrongAnswersDto.setWrongAnswers(wrongAnswers);
			result.add(wrongAnswersDto);
		}
		return result;
	}

}
