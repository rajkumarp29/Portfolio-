package com.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.entity.PastEmployment;
import com.portfolio.service.PastEmploymentService;

@RestController
@RequestMapping("/api/employment")
@CrossOrigin
public class PastEmploymentController {

    @Autowired
    private PastEmploymentService service;

    @PostMapping
    public PastEmployment create(@RequestBody PastEmployment employment) {
        return service.createEmployment(employment);
    }

    @GetMapping("/{userId}")
    public List<PastEmployment> getByUser(@PathVariable Long userId) {
        return service.getEmploymentHistory(userId);
    }
}
