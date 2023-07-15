package wl.open_house_api.service.interfaces;

import wl.open_house_api.model.avaliacao.request.AvaliarFilmeRequest;

public interface ValidadorAvaliacaoDeFilme {

    void validar(AvaliarFilmeRequest avaliar);
}
