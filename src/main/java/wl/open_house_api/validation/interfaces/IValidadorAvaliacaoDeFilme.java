package wl.open_house_api.validation.interfaces;

import wl.open_house_api.modules.avaliacao.model.request.AvaliarFilmeRequest;

import java.util.UUID;

public interface IValidadorAvaliacaoDeFilme {

    void validar(AvaliarFilmeRequest avaliar, UUID userID);
}
