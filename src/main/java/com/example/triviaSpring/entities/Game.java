package com.example.triviaSpring.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Game {
	@Id
	@SequenceGenerator(
	        name = "game_sequence",
	        sequenceName = "game_sequence",
	        allocationSize = 1
	)
	@GeneratedValue(
	        strategy = GenerationType.SEQUENCE,
	        generator = "game_sequence"
	)
	private Long id;
	
	@OneToMany(mappedBy = "game")
	private List<Team> teams;
	
	@OneToMany(mappedBy = "game")
	private List<Round> rounds;
	private LocalDateTime date;
	private boolean deleted = false;
}
