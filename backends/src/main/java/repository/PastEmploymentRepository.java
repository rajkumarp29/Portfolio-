package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.PastEmployment;

public interface PastEmploymentRepository extends JpaRepository<PastEmployment, Long> {

	    List<PastEmployment> findByUserIdOrderByStartDateDesc(Long userId);
	}