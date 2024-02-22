package com.example.demo.service;


import com.example.demo.domain.Diet;
import com.example.demo.domain.DietQuestion;
import com.example.demo.dto.user.DietQuestionDto;
import com.example.demo.repository.DietRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DietService {

    private final DietRepository dietRepository;
    private final DietQuestionService dietQuestionService;

    @Transactional
    public Long join(Diet diet){
        Diet saved = dietRepository.save(diet);

        return saved.getId();
    }
    @Transactional
    public String createGptResponse(DietQuestion dietQuestion){
        String diet = dietQuestionService.createDiet(dietQuestion);

        char x[] = diet.toCharArray();
        int cnt=0;
        for(int i =0 ;i<x.length;i++){
            if(x[i] == '\n'){
                cnt++;
            }
        }
        if(cnt != 5){

        }

        return diet;

    }

}
