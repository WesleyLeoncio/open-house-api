package wl.open_house_api.modules.filme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wl.open_house_api.modules.filme.model.entity.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
