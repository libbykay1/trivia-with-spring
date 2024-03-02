package com.example.triviaSpring.mappers;

import org.mapstruct.Mapper;

import com.example.triviaSpring.dtos.TeamRequestDto;
import com.example.triviaSpring.dtos.TeamResponseDto;
import com.example.triviaSpring.entities.Team;

@Mapper(componentModel = "spring")
public interface TeamMapper {

	Team requestDtoToEntity(TeamRequestDto teamRequestDto);

	TeamResponseDto entityToResponseDto(Team entity);

}
