package wl.open_house_api.service.interfaces;

import wl.open_house_api.model.avaliacao.request.AvaliarFilmeRequest;
import wl.open_house_api.model.avaliacao.response.AvaliacaoDeFilmesResponse;

public interface AvaliacaoMetodos {

    public void avaliarFilme(AvaliarFilmeRequest avaliar);
}
