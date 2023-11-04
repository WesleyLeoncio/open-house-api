package wl.open_house_api.modules.categoria_filme.model.request;

import jakarta.validation.constraints.NotNull;

public record CategoriaFilmeRequestCategoria(@NotNull Long categoriaId) {
}
