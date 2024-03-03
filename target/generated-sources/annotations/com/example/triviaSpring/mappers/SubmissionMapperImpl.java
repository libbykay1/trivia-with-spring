package com.example.triviaSpring.mappers;

import com.example.triviaSpring.dtos.QuestionResponseDto;
import com.example.triviaSpring.dtos.RoundResponseDto;
import com.example.triviaSpring.dtos.SubmissionRequestDto;
import com.example.triviaSpring.dtos.SubmissionResponseDto;
import com.example.triviaSpring.dtos.TeamResponseDto;
import com.example.triviaSpring.entities.Question;
import com.example.triviaSpring.entities.Round;
import com.example.triviaSpring.entities.Submission;
import com.example.triviaSpring.entities.Team;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-03T13:32:07-0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class SubmissionMapperImpl implements SubmissionMapper {

    @Override
    public Submission requestDtoToEntity(SubmissionRequestDto submissionRequestDto) {
        if ( submissionRequestDto == null ) {
            return null;
        }

        Submission submission = new Submission();

        submission.setDoubleOrNothing( submissionRequestDto.isDoubleOrNothing() );
        List<String> list = submissionRequestDto.getAnswers();
        if ( list != null ) {
            submission.setAnswers( new ArrayList<String>( list ) );
        }

        return submission;
    }

    @Override
    public SubmissionResponseDto entityToResponseDto(Submission entity) {
        if ( entity == null ) {
            return null;
        }

        SubmissionResponseDto submissionResponseDto = new SubmissionResponseDto();

        submissionResponseDto.setId( entity.getId() );
        submissionResponseDto.setTeam( teamToTeamResponseDto( entity.getTeam() ) );
        submissionResponseDto.setRound( roundToRoundResponseDto( entity.getRound() ) );
        List<String> list = entity.getAnswers();
        if ( list != null ) {
            submissionResponseDto.setAnswers( new ArrayList<String>( list ) );
        }
        submissionResponseDto.setDoubleOrNothing( entity.getDoubleOrNothing() );
        submissionResponseDto.setPoints( entity.getPoints() );

        return submissionResponseDto;
    }

    protected TeamResponseDto teamToTeamResponseDto(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamResponseDto teamResponseDto = new TeamResponseDto();

        teamResponseDto.setId( team.getId() );
        teamResponseDto.setName( team.getName() );
        teamResponseDto.setTotalPoints( team.getTotalPoints() );

        return teamResponseDto;
    }

    protected QuestionResponseDto questionToQuestionResponseDto(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionResponseDto questionResponseDto = new QuestionResponseDto();

        questionResponseDto.setId( question.getId() );
        questionResponseDto.setText( question.getText() );
        List<String> list = question.getAcceptableAnswers();
        if ( list != null ) {
            questionResponseDto.setAcceptableAnswers( new ArrayList<String>( list ) );
        }
        questionResponseDto.setAvailablePoints( question.getAvailablePoints() );
        questionResponseDto.setNumberInRound( question.getNumberInRound() );
        questionResponseDto.setImageUrl( question.getImageUrl() );
        questionResponseDto.setBonus( question.isBonus() );

        return questionResponseDto;
    }

    protected List<QuestionResponseDto> questionListToQuestionResponseDtoList(List<Question> list) {
        if ( list == null ) {
            return null;
        }

        List<QuestionResponseDto> list1 = new ArrayList<QuestionResponseDto>( list.size() );
        for ( Question question : list ) {
            list1.add( questionToQuestionResponseDto( question ) );
        }

        return list1;
    }

    protected RoundResponseDto roundToRoundResponseDto(Round round) {
        if ( round == null ) {
            return null;
        }

        RoundResponseDto roundResponseDto = new RoundResponseDto();

        roundResponseDto.setId( round.getId() );
        roundResponseDto.setRoundNumber( round.getRoundNumber() );
        roundResponseDto.setTitle( round.getTitle() );
        roundResponseDto.setDescription( round.getDescription() );
        roundResponseDto.setQuestions( questionListToQuestionResponseDtoList( round.getQuestions() ) );
        List<String> list1 = round.getCorrectAnswers();
        if ( list1 != null ) {
            roundResponseDto.setCorrectAnswers( new ArrayList<String>( list1 ) );
        }
        roundResponseDto.setVisible( round.isVisible() );

        return roundResponseDto;
    }
}
