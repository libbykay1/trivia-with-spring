package com.example.triviaSpring.mappers;

import com.example.triviaSpring.dtos.QuestionRequestDto;
import com.example.triviaSpring.dtos.QuestionResponseDto;
import com.example.triviaSpring.dtos.RoundRequestDto;
import com.example.triviaSpring.dtos.RoundResponseDto;
import com.example.triviaSpring.entities.Question;
import com.example.triviaSpring.entities.Round;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-03T12:25:29-0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class RoundMapperImpl implements RoundMapper {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<RoundResponseDto> entitiesToDtos(List<Round> roundEntities) {
        if ( roundEntities == null ) {
            return null;
        }

        List<RoundResponseDto> list = new ArrayList<RoundResponseDto>( roundEntities.size() );
        for ( Round round : roundEntities ) {
            list.add( roundEntityToResponseDto( round ) );
        }

        return list;
    }

    @Override
    public RoundResponseDto roundEntityToResponseDto(Round round) {
        if ( round == null ) {
            return null;
        }

        RoundResponseDto roundResponseDto = new RoundResponseDto();

        roundResponseDto.setId( round.getId() );
        roundResponseDto.setRoundNumber( round.getRoundNumber() );
        roundResponseDto.setTitle( round.getTitle() );
        roundResponseDto.setDescription( round.getDescription() );
        roundResponseDto.setQuestions( questionMapper.entitiesToDtos( round.getQuestions() ) );
        List<String> list1 = round.getCorrectAnswers();
        if ( list1 != null ) {
            roundResponseDto.setCorrectAnswers( new ArrayList<String>( list1 ) );
        }
        roundResponseDto.setVisible( round.isVisible() );

        return roundResponseDto;
    }

    @Override
    public Round roundRequestDtoToEntity(RoundRequestDto roundRequestDto) {
        if ( roundRequestDto == null ) {
            return null;
        }

        Round round = new Round();

        round.setTitle( roundRequestDto.getTitle() );
        round.setDescription( roundRequestDto.getDescription() );
        round.setQuestions( questionRequestDtoListToQuestionList( roundRequestDto.getQuestions() ) );
        List<String> list1 = roundRequestDto.getCorrectAnswers();
        if ( list1 != null ) {
            round.setCorrectAnswers( new ArrayList<String>( list1 ) );
        }

        return round;
    }

    @Override
    public Round responseDtoToEntity(RoundResponseDto roundResponseDto) {
        if ( roundResponseDto == null ) {
            return null;
        }

        Round round = new Round();

        round.setId( roundResponseDto.getId() );
        round.setRoundNumber( roundResponseDto.getRoundNumber() );
        round.setTitle( roundResponseDto.getTitle() );
        round.setDescription( roundResponseDto.getDescription() );
        round.setQuestions( questionResponseDtoListToQuestionList( roundResponseDto.getQuestions() ) );
        List<String> list1 = roundResponseDto.getCorrectAnswers();
        if ( list1 != null ) {
            round.setCorrectAnswers( new ArrayList<String>( list1 ) );
        }
        round.setVisible( roundResponseDto.isVisible() );

        return round;
    }

    protected List<Question> questionRequestDtoListToQuestionList(List<QuestionRequestDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Question> list1 = new ArrayList<Question>( list.size() );
        for ( QuestionRequestDto questionRequestDto : list ) {
            list1.add( questionMapper.requestDtoToEntity( questionRequestDto ) );
        }

        return list1;
    }

    protected Question questionResponseDtoToQuestion(QuestionResponseDto questionResponseDto) {
        if ( questionResponseDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setId( questionResponseDto.getId() );
        question.setText( questionResponseDto.getText() );
        List<String> list = questionResponseDto.getAcceptableAnswers();
        if ( list != null ) {
            question.setAcceptableAnswers( new ArrayList<String>( list ) );
        }
        question.setAvailablePoints( questionResponseDto.getAvailablePoints() );
        question.setNumberInRound( questionResponseDto.getNumberInRound() );
        question.setImageUrl( questionResponseDto.getImageUrl() );

        return question;
    }

    protected List<Question> questionResponseDtoListToQuestionList(List<QuestionResponseDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Question> list1 = new ArrayList<Question>( list.size() );
        for ( QuestionResponseDto questionResponseDto : list ) {
            list1.add( questionResponseDtoToQuestion( questionResponseDto ) );
        }

        return list1;
    }
}
