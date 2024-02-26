package com.example.demo.repository;

import com.example.demo.domain.Diet;
import com.example.demo.domain.DietQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DietRepository extends JpaRepository<Diet, Long> {
    Diet findByDietQuestionId(Long id);
}
