package tech.desafio.magalums.dto;

import tech.desafio.magalums.entity.Channel;
import tech.desafio.magalums.entity.Notification;
import tech.desafio.magalums.entity.Status;

import java.time.LocalDateTime;

public record ScheduleNotificationDTO(LocalDateTime shippingDateTime, String destination, String message, Channel.Values channel) {
    public Notification toNotification() {
        return new Notification(
                shippingDateTime,
                destination,
                message,
                channel.toChannel(),
                Status.Values.PENDING.toStatus()
        );
    }
}
