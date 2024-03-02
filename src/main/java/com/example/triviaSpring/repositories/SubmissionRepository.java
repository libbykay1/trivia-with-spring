package com.example.triviaSpring.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.triviaSpring.entities.Submission;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {
	Optional<Submission> findByIdAndDeletedFalse(Long id);

	List<Submission> findAllByDeletedFalse();
}
