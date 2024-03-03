package com.example.triviaSpring.entities;


import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Question {

	@Id
	@SequenceGenerator(
	        name = "question_sequence",
	        sequenceName = "question_sequence",
	        allocationSize = 1
	)
	@GeneratedValue(
	        strategy = GenerationType.SEQUENCE,
	        generator = "question_sequence"
	)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "round_id")
	private Round round;
	
	private String text;
	
	@ElementCollection
    @CollectionTable(name = "question_acceptable_answers", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "acceptable_answer")
	private List<String> acceptableAnswers;
	
	private Double availablePoints;
	
	private Integer numberInRound;
	
	private String imageUrl;
	
	private boolean deleted = false;
	
	private boolean bonus = false;
	
	
}
