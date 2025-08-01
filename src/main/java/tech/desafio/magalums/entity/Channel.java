package tech.desafio.magalums.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "channel")
public class Channel {

    @Id
    @Column(name = "channel_id")
    private Long channelId;

    @Column(name = "name")
    private String name;

    public Channel() {
    }

    public Channel(Long channelId, String name) {
        this.channelId = channelId;
        this.name = name;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum Values {
        EMAIL(1L,"email"),
        SMS(2L, "sms"),
        PUSH(3L, "push"),
        WHATSAPP(4L,"whatsapp");

        private Long id;
        private String name;

        Values(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Channel toChannel() {
            return new Channel(id, name);
        }
    }
}
