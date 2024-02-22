package com.example.demo.service;


import com.example.demo.domain.Diet;
import com.example.demo.repository.DietRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DietService {

    private final DietRepository dietRepository;

    @Transactional
    public Long join(Diet diet){
        Diet saved = dietRepository.save(diet);

        return saved.getId();
    }


}
