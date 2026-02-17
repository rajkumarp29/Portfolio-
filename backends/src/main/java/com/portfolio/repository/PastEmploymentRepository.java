package com.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.entity.PastEmployment;

public interface PastEmploymentRepository extends JpaRepository<PastEmployment, Long> {

	    List<PastEmployment> findByUserIdOrderByStartDateDesc(Long userId);
	}