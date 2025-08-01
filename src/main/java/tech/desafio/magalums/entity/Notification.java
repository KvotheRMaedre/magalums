package tech.desafio.magalums.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @Column(name = "notification_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long notificationId;

    @Column(name = "shipping_date_time")
    private LocalDateTime shippingDateTime;

    @Column(name = "destination")
    private String destination;

    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    public Notification() {
    }

    public Notification(LocalDateTime shippingDateTime, String destination, String message, Channel channel, Status status) {
        this.shippingDateTime = shippingDateTime;
        this.destination = destination;
        this.message = message;
        this.channel = channel;
        this.status = status;
    }

    public Notification(Long notificationId, LocalDateTime shippingDateTime, String destination, String message, Channel channel, Status status) {
        this.notificationId = notificationId;
        this.shippingDateTime = shippingDateTime;
        this.destination = destination;
        this.message = message;
        this.channel = channel;
        this.status = status;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public LocalDateTime getShippingDateTime() {
        return shippingDateTime;
    }

    public void setShippingDateTime(LocalDateTime shippingDateTime) {
        this.shippingDateTime = shippingDateTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
