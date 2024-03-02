package com.example.triviaSpring.entities;


import java.sql.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Round {
	@Id
	@SequenceGenerator(
	        name = "round_sequence",
	        sequenceName = "round_sequence",
	        allocationSize = 1
	)
	@GeneratedValue(
	        strategy = GenerationType.SEQUENCE,
	        generator = "round_sequence"
	)
	private Long id;
	
	private Integer roundNumber;
	
	private String title;
	
	private String description;
	
	@OneToMany(mappedBy = "round")
	private List<Question> questions;
	
	@OneToMany(mappedBy = "round")
	private List<Submission> submissions;
	
	@ElementCollection
    @CollectionTable(name = "round_correct_answers", joinColumns = @JoinColumn(name = "round_id"))
    @Column(name = "acceptable_answer")
	private List<String> correctAnswers;
	
	private boolean visible = false;
	
	@ManyToOne
	@JoinColumn(name="game_id")
	private Game game;
	
	private boolean deleted = false;
}
