package com.example.triviaSpring.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.triviaSpring.dtos.QuestionRequestDto;
import com.example.triviaSpring.dtos.QuestionResponseDto;
import com.example.triviaSpring.entities.Question;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
	QuestionResponseDto entityToResponseDto(Question entity);

	List<QuestionResponseDto> entitiesToDtos(List<Question> allByDeletedFalse);

	Question requestDtoToEntity(QuestionRequestDto questionRequestDto);
}
