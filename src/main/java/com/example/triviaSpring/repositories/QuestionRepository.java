package com.example.triviaSpring.repositories;

import com.example.triviaSpring.entities.Question;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

	Optional<Question> findByIdAndDeletedFalse(Long id);
	
	List<Question> findAllByDeletedFalse();

}