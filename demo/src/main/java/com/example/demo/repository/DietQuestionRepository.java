package com.example.demo.repository;

import com.example.demo.domain.DietQuestion;
import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DietQuestionRepository extends JpaRepository<DietQuestion, Long> {
    List<DietQuestion> findAllByUserId(Long id);
}
