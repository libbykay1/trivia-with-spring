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
public class Submission {
	@Id
	@SequenceGenerator(
	        name = "submission_sequence",
	        sequenceName = "submission_sequence",
	        allocationSize = 1
	)
	@GeneratedValue(
	        strategy = GenerationType.SEQUENCE,
	        generator = "submission_sequence"
	)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;
	
	@ManyToOne
	@JoinColumn(name = "round_id")
	private Round round;
	
	@ElementCollection
    @CollectionTable(name = "submission_answers", joinColumns = @JoinColumn(name = "submission_id"))
    @Column(name = "answers")
	private List<String> answers;
	
	private boolean doubleOrNothing;
	
	private Double points;
	
	private boolean deleted = false;
	
	public boolean getDoubleOrNothing() {
		return doubleOrNothing;
	}
	
	public void setDoubleOrNothing(boolean doubleOrNothing) {
		this.doubleOrNothing = doubleOrNothing;
	}

}
