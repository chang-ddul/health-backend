package com.example.demo.repository;

import com.example.demo.domain.DietQuestion;
import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietQuestionRepository extends JpaRepository<DietQuestion, Long> {

}
