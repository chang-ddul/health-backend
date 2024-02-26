package com.example.demo.service;


import com.example.demo.domain.Diet;
import com.example.demo.domain.DietQuestion;
import com.example.demo.exception.DietException;
import com.example.demo.repository.DietRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public Diet createGptResponse(DietQuestion dietQuestion){
        String diet = dietQuestionService.createDiet(dietQuestion);

        int count = 0;
        for (int i = 0; i < diet.length(); i++) {
            if (diet.charAt(i) == '\\' && diet.charAt(i + 1) == 'n') {
                count++;
            }
        }

        if(count != 5){
            createGptResponse(dietQuestion);
        }

        String regex = "(.*?)\\\\n(\\d+kcal)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(diet);
        // 아침, 점심, 저녁 정보 추출
        String breakfast = null;
        String lunch = null;
        String dinner = null;
        int breakfastKcal = 0;
        int lunchKcal = 0;
        int dinnerKcal = 0;

        while (matcher.find()) {
            String menu = matcher.group(1);
            String kcal = matcher.group(2);
            if (breakfast == null) {
                breakfast = menu;
                breakfastKcal = Integer.parseInt(kcal.substring(0,kcal.length()-4));
            } else if (lunch == null) {
                lunch = menu.substring(2);
                lunchKcal = Integer.parseInt(kcal.substring(0,kcal.length()-4));

            } else {
                dinner = menu.substring(2);
                dinnerKcal = Integer.parseInt(kcal.substring(0,kcal.length()-4));
            }
        }

        // 칼로리 정보 추출

        int sumOfKcal = breakfastKcal+lunchKcal+dinnerKcal;

        Diet newDiet = Diet.createDiet(dietQuestion, breakfast, breakfastKcal, lunch, lunchKcal, dinner, dinnerKcal, sumOfKcal);

        return newDiet;

    }

    @Transactional
    public void deleteDiet(Long Id){
        dietRepository.deleteById(Id);
    }

    public Diet findByDietQuestionId(Long DietQuestionId){
        return dietRepository.findByDietQuestionId(DietQuestionId);
    }

}
