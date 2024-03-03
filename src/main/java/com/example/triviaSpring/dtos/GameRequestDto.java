package com.example.triviaSpring.dtos;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GameRequestDto {
	private LocalDateTime date;
}
