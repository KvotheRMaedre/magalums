package tech.desafio.magalums.controller;

import jakarta.websocket.server.PathParam;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.desafio.magalums.dto.ScheduleNotificationDTO;
import tech.desafio.magalums.entity.Notification;
import tech.desafio.magalums.service.NotificationService;

@RestController
@RequestMapping("/v1/notification")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Void> scheduleNotification(@RequestBody ScheduleNotificationDTO request) {
        notificationService.scheduleNotification(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable("notificationId") Long notificationId) {
        var notification = notificationService.getNotificationById(notificationId);
        return notification.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{notificationId}")
    public ResponseEntity<Void> cancelNotification(@PathVariable("notificationId") Long notificationId) {
        notificationService.cancelNotification(notificationId);
        return ResponseEntity.noContent().build();
    }
}
