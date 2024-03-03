package com.example.triviaSpring.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Team {
	@Id
	@SequenceGenerator(
	        name = "team_sequence",
	        sequenceName = "team_sequence",
	        allocationSize = 1
	)
	@GeneratedValue(
	        strategy = GenerationType.SEQUENCE,
	        generator = "team_sequence"
	)
	private Long id;
	
	private String name;
	
	private Double totalPoints = 0.0;
	
	@OneToMany(mappedBy = "team")
	private List<Submission> submissions;
	
	private boolean deleted = false;
	
	@ManyToOne
	@JoinColumn(name="game_id")
	private Game game;
	

}
