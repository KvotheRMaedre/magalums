package tech.desafio.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.desafio.magalums.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
