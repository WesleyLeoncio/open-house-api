package wl.open_house_api.modules.filme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wl.open_house_api.modules.filme.model.entity.Filme;

import java.util.UUID;

public interface FilmeRepository extends JpaRepository<Filme, UUID> {
}
