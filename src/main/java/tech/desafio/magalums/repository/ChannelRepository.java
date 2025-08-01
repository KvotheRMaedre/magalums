package tech.desafio.magalums.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.desafio.magalums.entity.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
