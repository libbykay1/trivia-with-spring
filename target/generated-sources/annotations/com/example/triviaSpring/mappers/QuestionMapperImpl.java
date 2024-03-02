package com.example.triviaSpring.mappers;

import com.example.triviaSpring.dtos.QuestionRequestDto;
import com.example.triviaSpring.dtos.QuestionResponseDto;
import com.example.triviaSpring.entities.Question;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-01T14:03:01-0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public QuestionResponseDto entityToResponseDto(Question entity) {
        if ( entity == null ) {
            return null;
        }

        QuestionResponseDto questionResponseDto = new QuestionResponseDto();

        questionResponseDto.setId( entity.getId() );
        questionResponseDto.setText( entity.getText() );
        List<String> list = entity.getAcceptableAnswers();
        if ( list != null ) {
            questionResponseDto.setAcceptableAnswers( new ArrayList<String>( list ) );
        }
        questionResponseDto.setAvailablePoints( entity.getAvailablePoints() );
        questionResponseDto.setNumberInRound( entity.getNumberInRound() );
        questionResponseDto.setImageUrl( entity.getImageUrl() );

        return questionResponseDto;
    }

    @Override
    public List<QuestionResponseDto> entitiesToDtos(List<Question> allByDeletedFalse) {
        if ( allByDeletedFalse == null ) {
            return null;
        }

        List<QuestionResponseDto> list = new ArrayList<QuestionResponseDto>( allByDeletedFalse.size() );
        for ( Question question : allByDeletedFalse ) {
            list.add( entityToResponseDto( question ) );
        }

        return list;
    }

    @Override
    public Question requestDtoToEntity(QuestionRequestDto questionRequestDto) {
        if ( questionRequestDto == null ) {
            return null;
        }

        Question question = new Question();

        question.setText( questionRequestDto.getText() );
        List<String> list = questionRequestDto.getAcceptableAnswers();
        if ( list != null ) {
            question.setAcceptableAnswers( new ArrayList<String>( list ) );
        }
        question.setAvailablePoints( questionRequestDto.getAvailablePoints() );
        question.setNumberInRound( questionRequestDto.getNumberInRound() );
        question.setDeleted( questionRequestDto.isDeleted() );

        return question;
    }
}
