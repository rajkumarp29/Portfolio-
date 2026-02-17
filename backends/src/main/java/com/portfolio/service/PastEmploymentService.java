package com.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.entity.PastEmployment;
import com.portfolio.repository.PastEmploymentRepository;

@Service
public class PastEmploymentService {

    @Autowired
    private PastEmploymentRepository repository;

    public PastEmployment createEmployment(PastEmployment employment) {
        return repository.save(employment);
    }

    public List<PastEmployment> getEmploymentHistory(Long userId) {
        return repository.findByUserIdOrderByStartDateDesc(userId);
    }
}