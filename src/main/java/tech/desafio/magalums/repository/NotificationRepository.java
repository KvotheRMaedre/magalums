package tech.desafio.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.desafio.magalums.entity.Notification;
import tech.desafio.magalums.entity.Status;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByStatusInAndShippingDateTimeBefore(List<Status> status, LocalDateTime dateTime);
}
