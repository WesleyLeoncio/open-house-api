package wl.open_house_api.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import wl.open_house_api.model.avaliacao.request.AvaliarFilmeRequest;
import wl.open_house_api.model.avaliacao.response.AvaliacaoDeFilmesResponse;

public interface IAvaliacaoService {

    void avaliarFilme(AvaliarFilmeRequest avaliar);

    Page<AvaliacaoDeFilmesResponse> listarFilmesAvaliados(Pageable pageable);

    Page<AvaliacaoDeFilmesResponse> listarFilmesAvaliadosPorUser(Pageable pageable, Long id);
}
