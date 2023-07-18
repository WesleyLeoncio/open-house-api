package wl.open_house_api.model.avaliacao.response;

import wl.open_house_api.model.filme.response.FilmeResponse;

public record AvaliacaoDeFilmesResponse(
        Long id,
        FilmeResponse filme,
        int nota
) {
}
