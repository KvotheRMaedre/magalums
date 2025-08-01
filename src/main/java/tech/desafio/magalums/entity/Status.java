package tech.desafio.magalums.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @Column(name = "status_id")
    private Long statusId;

    @Column(name = "name")
    private String name;

    public Status() {
    }

    public Status(Long statusId, String name) {
        this.statusId = statusId;
        this.name = name;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum Values {
        PENDING(1L, "pending"),
        SUCCESS(2L, "success"),
        ERROR(3L, "error"),
        CANCELED(4L, "canceled");

        private Long id;
        private String name;

        Values(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Status toStatus() {
            return new Status(id, name);
        }
    }
}
