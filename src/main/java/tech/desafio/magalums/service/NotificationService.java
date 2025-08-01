package tech.desafio.magalums.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.desafio.magalums.dto.ScheduleNotificationDTO;
import tech.desafio.magalums.entity.Notification;
import tech.desafio.magalums.entity.Status;
import tech.desafio.magalums.repository.NotificationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(ScheduleNotificationDTO dto) {
        notificationRepository.save(dto.toNotification());
    }

    public Optional<Notification> getNotificationById(Long notificationId) {
        return notificationRepository.findById(notificationId);
    }

    public void cancelNotification(Long notificationId) {
        var notification = notificationRepository.findById(notificationId);

        if (notification.isPresent()) {
            notification.get().setStatus(Status.Values.CANCELED.toStatus());
            notificationRepository.save(notification.get());
        }
    }

    public void checkAndSend(LocalDateTime dateTime){
        var listNotifications = notificationRepository.findByStatusInAndShippingDateTimeBefore(
                List.of(
                    Status.Values.PENDING.toStatus(),
                    Status.Values.ERROR.toStatus()
                ), dateTime);

        listNotifications.forEach(sendNotification());
    }

    private Consumer<Notification> sendNotification() {
        return notification -> {
            // TODO - realizar envio
            notification.setStatus(Status.Values.SUCCESS.toStatus());
            notificationRepository.save(notification);
        };
    }
}
