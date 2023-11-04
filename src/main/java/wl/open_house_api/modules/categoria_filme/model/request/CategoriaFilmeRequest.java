package wl.open_house_api.modules.categoria_filme.model.request;

import jakarta.validation.constraints.NotNull;

public record CategoriaFilmeRequest(@NotNull Long categoriaId, @NotNull Long filmeId) {
}
