package com.example.triviaSpring.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.triviaSpring.dtos.RoundRequestDto;
import com.example.triviaSpring.dtos.RoundResponseDto;
import com.example.triviaSpring.entities.Round;

@Mapper(componentModel = "spring", uses = { QuestionMapper.class })
public interface RoundMapper {
	List<RoundResponseDto> entitiesToDtos(List<Round> roundEntities);

	RoundResponseDto roundEntityToResponseDto(Round round);

	Round roundRequestDtoToEntity(RoundRequestDto roundRequestDto);

	Round responseDtoToEntity(RoundResponseDto roundResponseDto);

}
