package wl.open_house_api.modules.avaliacao.model.response;

import wl.open_house_api.modules.filme.model.response.FilmeResponse;

public record AvaliacaoDeFilmesResponse(
        Long id,
        FilmeResponse filme,
        int nota
) {
}
