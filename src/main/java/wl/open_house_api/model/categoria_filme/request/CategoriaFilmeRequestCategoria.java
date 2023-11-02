package wl.open_house_api.model.categoria_filme.request;

import jakarta.validation.constraints.NotNull;

public record CategoriaFilmeRequestCategoria(@NotNull Long categoriaId) {
}
