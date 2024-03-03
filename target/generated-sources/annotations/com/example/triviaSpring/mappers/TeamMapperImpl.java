package com.example.triviaSpring.mappers;

import com.example.triviaSpring.dtos.TeamRequestDto;
import com.example.triviaSpring.dtos.TeamResponseDto;
import com.example.triviaSpring.entities.Team;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-03T13:32:07-0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class TeamMapperImpl implements TeamMapper {

    @Override
    public Team requestDtoToEntity(TeamRequestDto teamRequestDto) {
        if ( teamRequestDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setName( teamRequestDto.getName() );

        return team;
    }

    @Override
    public TeamResponseDto entityToResponseDto(Team entity) {
        if ( entity == null ) {
            return null;
        }

        TeamResponseDto teamResponseDto = new TeamResponseDto();

        teamResponseDto.setId( entity.getId() );
        teamResponseDto.setName( entity.getName() );
        teamResponseDto.setTotalPoints( entity.getTotalPoints() );

        return teamResponseDto;
    }
}
