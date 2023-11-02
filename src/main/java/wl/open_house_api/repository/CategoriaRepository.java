package wl.open_house_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wl.open_house_api.model.categoria.entiy.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
