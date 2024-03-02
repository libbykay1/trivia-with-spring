package com.example.triviaSpring.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.triviaSpring.entities.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
	Optional<Team> findByIdAndDeletedFalse(Long id);

	List<Team> findAllByDeletedFalse();

}
