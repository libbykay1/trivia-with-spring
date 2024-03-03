package com.example.triviaSpring.mappers;

import com.example.triviaSpring.dtos.GameRequestDto;
import com.example.triviaSpring.dtos.GameResponseDto;
import com.example.triviaSpring.dtos.TeamResponseDto;
import com.example.triviaSpring.entities.Game;
import com.example.triviaSpring.entities.Team;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-03T13:21:03-0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class GameMapperImpl implements GameMapper {

    @Autowired
    private RoundMapper roundMapper;
    @Autowired
    private TeamMapper teamMapper;

    @Override
    public GameResponseDto entityToDto(Game entity) {
        if ( entity == null ) {
            return null;
        }

        GameResponseDto gameResponseDto = new GameResponseDto();

        gameResponseDto.setId( entity.getId() );
        gameResponseDto.setDate( entity.getDate() );
        gameResponseDto.setTeams( teamListToTeamResponseDtoList( entity.getTeams() ) );
        gameResponseDto.setRounds( roundMapper.entitiesToDtos( entity.getRounds() ) );

        return gameResponseDto;
    }

    @Override
    public Game dtoToEntity(GameRequestDto gameRequestDto) {
        if ( gameRequestDto == null ) {
            return null;
        }

        Game game = new Game();

        game.setDate( gameRequestDto.getDate() );

        return game;
    }

    protected List<TeamResponseDto> teamListToTeamResponseDtoList(List<Team> list) {
        if ( list == null ) {
            return null;
        }

        List<TeamResponseDto> list1 = new ArrayList<TeamResponseDto>( list.size() );
        for ( Team team : list ) {
            list1.add( teamMapper.entityToResponseDto( team ) );
        }

        return list1;
    }
}
