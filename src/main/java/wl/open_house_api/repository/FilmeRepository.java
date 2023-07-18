package wl.open_house_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wl.open_house_api.model.filme.entity.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
