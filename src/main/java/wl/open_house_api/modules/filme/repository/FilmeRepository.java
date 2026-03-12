package wl.open_house_api.modules.filme.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import wl.open_house_api.modules.filme.model.entity.Filme;

import java.util.UUID;

public interface FilmeRepository extends JpaRepository<Filme, UUID> {

    Page<Filme> findByNomeContainingIgnoreCase(Pageable pageable,String name);
}
