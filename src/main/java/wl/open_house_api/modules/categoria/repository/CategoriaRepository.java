package wl.open_house_api.modules.categoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wl.open_house_api.modules.categoria.model.entiy.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
