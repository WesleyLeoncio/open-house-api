package wl.open_house_api.model.categoria_filme.response;

import wl.open_house_api.model.categoria.response.CategoriaResponse;
import wl.open_house_api.model.filme.response.FilmeResponse;

public record CategoriaFilmeResponse(CategoriaResponse categoria, FilmeResponse filme) {
}
