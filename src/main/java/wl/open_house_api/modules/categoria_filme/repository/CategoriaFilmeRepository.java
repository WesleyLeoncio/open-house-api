package wl.open_house_api.modules.categoria_filme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wl.open_house_api.modules.categoria_filme.model.entity.CategoriaFilme;
import wl.open_house_api.modules.categoria_filme.model.entity.CategoriaFilmeId;

public interface CategoriaFilmeRepository extends JpaRepository<CategoriaFilme, CategoriaFilmeId> {
}
