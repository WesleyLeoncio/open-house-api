package wl.open_house_api.model.categoria_filme.request;

import jakarta.validation.constraints.NotNull;

public record CategoriaFilmeRequest(@NotNull Long categoriaId, @NotNull Long filmeId) {
}
