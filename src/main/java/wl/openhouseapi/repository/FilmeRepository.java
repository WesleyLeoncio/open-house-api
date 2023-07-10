package wl.openhouseapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wl.openhouseapi.model.filme.entity.Filme;


public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
