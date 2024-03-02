package com.example.triviaSpring.repositories;

import com.example.triviaSpring.entities.Round;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundRepository extends JpaRepository<Round, Long> {

	Optional<Round> findByIdAndDeletedFalse(Long id);
	
	List<Round> findAllByDeletedFalse();

}