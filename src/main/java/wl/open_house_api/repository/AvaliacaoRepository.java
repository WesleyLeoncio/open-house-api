package wl.open_house_api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import wl.open_house_api.model.avaliacao.entity.AvaliacaoDeFilmes;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoDeFilmes, Long> {
    AvaliacaoDeFilmes findByFilmeIdAndUsuarioId(Long idFilme, Long idUsuario);

    Page<AvaliacaoDeFilmes> findAllByUsuarioId(Pageable pageable, Long id);
}
