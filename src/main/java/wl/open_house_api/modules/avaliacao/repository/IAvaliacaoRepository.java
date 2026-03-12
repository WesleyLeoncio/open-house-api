package wl.open_house_api.modules.avaliacao.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import wl.open_house_api.modules.avaliacao.model.entity.AvaliacaoDeFilmes;
import wl.open_house_api.modules.avaliacao.model.entity.AvaliacaoId;

import java.util.UUID;

public interface IAvaliacaoRepository extends JpaRepository<AvaliacaoDeFilmes, AvaliacaoId> {

    @Transactional
    @Modifying
    @Query("DELETE FROM AvaliacaoDeFilmes a WHERE a.filme.id = :filmeId")
    void deleteByFilmeId(UUID filmeId);

    @Transactional
    @Modifying
    void deleteByFilmeIdAndUsuarioId(UUID filmeId, UUID usuarioId);

    @Query("""
        SELECT a FROM AvaliacaoDeFilmes a
          WHERE a.usuario.id = :id
    """)
    Page<AvaliacaoDeFilmes> findAllByUsuarioId(Pageable pageable, UUID id);


    @Query("""
        SELECT a FROM AvaliacaoDeFilmes a
    """)
    Page<AvaliacaoDeFilmes> findAllAvalicoes(Pageable pageable);


    @Query("""
        SELECT a.nota FROM AvaliacaoDeFilmes a
          WHERE a.filme.id = :filmeId AND a.usuario.id = :usuarioId
    """)
    Integer findNotaByFilmeIdAndUsuarioId(UUID filmeId, UUID usuarioId);
}
