package wl.open_house_api.modules.avaliacao.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import wl.open_house_api.modules.avaliacao.model.request.AvaliarFilmeRequest;
import wl.open_house_api.modules.avaliacao.model.response.AvaliacaoDeFilmesNotaResponse;
import wl.open_house_api.modules.avaliacao.model.response.AvaliacaoDeFilmesResponse;

import java.util.UUID;

public interface IAvaliacaoService {

    void avaliarFilme(AvaliarFilmeRequest avaliar);

    Page<AvaliacaoDeFilmesResponse> listarFilmesAvaliados(Pageable pageable);

    Page<AvaliacaoDeFilmesResponse> listarFilmesAvaliadosPorUser(Pageable pageable, UUID id);

    AvaliacaoDeFilmesResponse listaAvaliacaoPorFilmeIdUserId(UUID filmeId, UUID usuarioId);

    AvaliacaoDeFilmesNotaResponse notaFilme(UUID filmeId, UUID usuarioId);
}
