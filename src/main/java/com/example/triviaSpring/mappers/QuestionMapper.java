package com.example.triviaSpring.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.triviaSpring.dtos.QuestionRequestDto;
import com.example.triviaSpring.dtos.QuestionResponseDto;
import com.example.triviaSpring.entities.Question;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
	QuestionResponseDto entityToResponseDto(Question entity);

	List<QuestionResponseDto> entitiesToDtos(List<Question> allByDeletedFalse);

	@Mappings({
        @Mapping(target = "numberInRound", source = "questionRequestDto.numberInRound")
    })
	Question requestDtoToEntity(QuestionRequestDto questionRequestDto);
}
