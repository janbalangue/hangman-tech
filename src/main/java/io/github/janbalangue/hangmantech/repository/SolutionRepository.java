package io.github.janbalangue.hangmantech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.github.janbalangue.hangmantech.entity.Solution;

public interface SolutionRepository extends JpaRepository<Solution, Integer> {
    
    @Query(value = "SELECT * FROM solutions ORDER BY RAND() LIMIT 1", nativeQuery = true)
    String findSolution();

}
