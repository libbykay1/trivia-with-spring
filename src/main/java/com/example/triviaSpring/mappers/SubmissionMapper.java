package com.example.triviaSpring.mappers;

import org.mapstruct.Mapper;

import com.example.triviaSpring.dtos.SubmissionRequestDto;
import com.example.triviaSpring.dtos.SubmissionResponseDto;
import com.example.triviaSpring.entities.Submission;

@Mapper(componentModel = "spring")
public interface SubmissionMapper {

	Submission requestDtoToEntity(SubmissionRequestDto submissionRequestDto);

	SubmissionResponseDto entityToResponseDto(Submission entity);

}
