package com.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
