package com.example.triviaSpring;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.triviaSpring.repositories.GameRepository;
import com.example.triviaSpring.repositories.QuestionRepository;
import com.example.triviaSpring.repositories.RoundRepository;
import com.example.triviaSpring.repositories.SubmissionRepository;
import com.example.triviaSpring.repositories.TeamRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.triviaSpring.entities.Game;
import com.example.triviaSpring.entities.Question;
import com.example.triviaSpring.entities.Round;
import com.example.triviaSpring.entities.Submission;
import com.example.triviaSpring.entities.Team;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Seeder implements CommandLineRunner {
	
	private final RoundRepository roundRepository;
	private final TeamRepository teamRepository;
	private final QuestionRepository questionRepository;
	private final SubmissionRepository submissionRepository;
	private final GameRepository gameRepository;
	
	@Override
	public void run(String... args) throws Exception{
		
		Game exampleGame = new Game();
		exampleGame.setDate(LocalDateTime.of(2024, 2, 27, 0, 0, 0));
		
		gameRepository.saveAll(Arrays.asList(new Game[] { exampleGame }));
		
		Team exampleTeam = new Team();
		exampleTeam.setName("False Bravado");
		exampleTeam.setTotalPoints(7.0);
		exampleTeam.setDeleted(false);
		exampleTeam.setGame(exampleGame);
		teamRepository.saveAll(Arrays.asList(new Team[] { exampleTeam }));
		
		Round exampleRound = new Round();
		exampleRound.setRoundNumber(1);
		exampleRound.setTitle("Find the connection");
		exampleRound.setDescription("See if you can identify what connects all the answers in this round. 1 point for each correct answer.");
		exampleRound.setGame(exampleGame);
		List<String> correctAnswers = new ArrayList<>();
		correctAnswers.add("The Bowl");
		correctAnswers.add("Bob");
		correctAnswers.add("Fade");
		correctAnswers.add("Fringe");
		correctAnswers.add("Rachel");
		correctAnswers.add("Crew");
		correctAnswers.add("Pixie dust");
		correctAnswers.add("They're all hairstyles.");
		exampleRound.setCorrectAnswers(correctAnswers);
		
		
		roundRepository.saveAll(Arrays.asList(new Round[] { exampleRound }));
		
		Question question1 = new Question();
		question1.setRound(exampleRound);
		question1.setText("This famous amphitheater is carved into a concave hillside against the backdrop of the Hollywood Hills:");
		List<String> acceptableAnswers1 = new ArrayList<>();
		acceptableAnswers1.add("bowl");
		question1.setAcceptableAnswers(acceptableAnswers1);
		question1.setNumberInRound(1);
		question1.setAvailablePoints(1.0);
		
		Question question2 = new Question();
		question2.setRound(exampleRound);
		question2.setText("What is the name of the tomato in VeggieTales?");
		List<String> acceptableAnswers2 = new ArrayList<>();
		acceptableAnswers2.add("bob");
		question2.setAcceptableAnswers(acceptableAnswers2);
		question2.setNumberInRound(2);
		question2.setAvailablePoints(1.0);
		
		Question question3 = new Question();
		question3.setRound(exampleRound);
		question3.setText("Name the third and final single from Kanye West’s The Life of Pablo, featuring vocals from Post Malone and Ty Dolla Sign: ");
		List<String> acceptableAnswers3 = new ArrayList<>();
		acceptableAnswers3.add("fade");
		question3.setAcceptableAnswers(acceptableAnswers3);
		question3.setNumberInRound(3);
		question3.setAvailablePoints(1.0);
		
		Question question4 = new Question();
		question4.setRound(exampleRound);
		question4.setText("What show is being represented at this 2010 Comic-Con panel?");
		List<String> acceptableAnswers4 = new ArrayList<>();
		acceptableAnswers4.add("fringe");
		question4.setAcceptableAnswers(acceptableAnswers4);
		question4.setNumberInRound(4);
		question4.setAvailablePoints(1.0);
		
		Question question5 = new Question();
		question5.setRound(exampleRound);
		question5.setText("This Biblical name spent over a hundred years in the top 200 most popular baby names, reaching its peak at #9 in 1996, until it fell to #227 in 2020: ");
		List<String> acceptableAnswers5 = new ArrayList<>();
		acceptableAnswers5.add("rachel");
		question5.setAcceptableAnswers(acceptableAnswers5);
		question5.setNumberInRound(5);
		question5.setAvailablePoints(1.0);
		
		Question question6 = new Question();
		question6.setRound(exampleRound);
		question6.setText("Mark Zuckerberg participated in tennis and what other sport when he was in high school?");
		List<String> acceptableAnswers6 = new ArrayList<>();
		acceptableAnswers6.add("crew");
		acceptableAnswers6.add("rowing");
		question6.setAcceptableAnswers(acceptableAnswers6);
		question6.setNumberInRound(6);
		question6.setAvailablePoints(1.0);
		
		Question question7 = new Question();
		question7.setRound(exampleRound);
		question7.setText("In the earliest productions of Peter Pan, there was no mention of this magical substance; it was added into the script after several reports of children injuring themselves trying to fly off their beds: ");
		List<String> acceptableAnswers7 = new ArrayList<>();
		acceptableAnswers7.add("pixie");
		acceptableAnswers7.add("pixey");
		question7.setAcceptableAnswers(acceptableAnswers7);
		question7.setNumberInRound(7);
		question7.setAvailablePoints(1.0);
		
		Question question8 = new Question();
		question8.setRound(exampleRound);
		question8.setText("What do all of the above answers have in common? ");
		List<String> acceptableAnswers8 = new ArrayList<>();
		acceptableAnswers8.add("hair");
		question8.setAcceptableAnswers(acceptableAnswers8);
		question8.setNumberInRound(8);
		question8.setAvailablePoints(1.0);
		
		questionRepository.saveAll(Arrays.asList(new Question[] { question1, question2, question3, question4, question5, question6, question7, question8 }));
		
		Submission exampleSubmission = new Submission();
		exampleSubmission.setTeam(exampleTeam);
		exampleSubmission.setRound(exampleRound);
		exampleSubmission.setDoubleOrNothing(false);
		exampleSubmission.setPoints(7.0);
		List<String> answers = new ArrayList<>();
		answers.add("hollywood bowl");
		answers.add("Bob");
		answers.add("Fade");
		answers.add("Fringe");
		answers.add("Elizabeth");
		answers.add("rowing");
		answers.add("pixie dust");
		answers.add("they're all hairstyles");
		exampleSubmission.setAnswers(answers);
		
		submissionRepository.saveAll(Arrays.asList(new Submission[] { exampleSubmission }));
		
		
	}

}
