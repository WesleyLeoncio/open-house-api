package wl.open_house_api.modules.categoria_filme.model.response;

import wl.open_house_api.modules.categoria.model.response.CategoriaResponse;
import wl.open_house_api.modules.filme.model.response.FilmeResponseCategoriaFilme;

public record CategoriaFilmeResponse(CategoriaResponse categoria, FilmeResponseCategoriaFilme filme) {
}
