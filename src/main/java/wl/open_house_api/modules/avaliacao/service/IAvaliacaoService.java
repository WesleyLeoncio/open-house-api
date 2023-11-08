package wl.open_house_api.modules.avaliacao.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import wl.open_house_api.modules.avaliacao.model.request.AvaliarFilmeRequest;
import wl.open_house_api.modules.avaliacao.model.response.AvaliacaoDeFilmesResponse;

public interface IAvaliacaoService {

    void avaliarFilme(AvaliarFilmeRequest avaliar);

    Page<AvaliacaoDeFilmesResponse> listarFilmesAvaliados(Pageable pageable);

    Page<AvaliacaoDeFilmesResponse> listarFilmesAvaliadosPorUser(Pageable pageable, Long id);

    AvaliacaoDeFilmesResponse listaAvaliacaoPorFilmeIdUserId(Long filmeId, Long usuarioId);

    Integer notaFilme(Long filmeId, Long usuarioId);
}
