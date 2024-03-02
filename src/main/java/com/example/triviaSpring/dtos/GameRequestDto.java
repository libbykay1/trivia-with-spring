package com.example.triviaSpring.dtos;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GameRequestDto {
	private Date date;
}
