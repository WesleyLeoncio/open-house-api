package wl.open_house_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wl.open_house_api.model.categoria_filme.entity.CategoriaFilme;
import wl.open_house_api.model.categoria_filme.entity.CategoriaFilmeId;

public interface CategoriaFilmeRepository extends JpaRepository<CategoriaFilme, CategoriaFilmeId> {
}
