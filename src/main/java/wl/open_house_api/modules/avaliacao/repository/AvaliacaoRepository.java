package wl.open_house_api.modules.avaliacao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wl.open_house_api.modules.avaliacao.model.entity.AvaliacaoDeFilmes;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoDeFilmes, Long> {

    AvaliacaoDeFilmes findByFilmeIdAndUsuarioId(Long filmeId, Long usuarioId);

    Page<AvaliacaoDeFilmes> findAllByUsuarioId(Pageable pageable, Long id);

    @Query("""
        SELECT a.nota FROM AvaliacaoDeFilmes a
          WHERE a.filme.id = :filmeId AND a.usuario.id = :usuarioId
    """)
    Integer findNotaByFilmeIdAndUsuarioId(Long filmeId, Long usuarioId);
}
