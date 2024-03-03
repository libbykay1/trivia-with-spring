package com.example.triviaSpring.mappers;

import org.mapstruct.Mapper;

import com.example.triviaSpring.dtos.GameRequestDto;
import com.example.triviaSpring.dtos.GameResponseDto;
import com.example.triviaSpring.entities.Game;

@Mapper(componentModel = "spring", uses = { RoundMapper.class, TeamMapper.class })
public interface GameMapper {
	GameResponseDto entityToDto(Game entity);

	Game dtoToEntity(GameRequestDto gameRequestDto);

}
