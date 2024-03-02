package com.example.triviaSpring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.triviaSpring.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{
	Optional<Game> findByIdAndDeletedFalse(Long id);
}
