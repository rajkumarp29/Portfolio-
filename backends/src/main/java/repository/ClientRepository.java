package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
