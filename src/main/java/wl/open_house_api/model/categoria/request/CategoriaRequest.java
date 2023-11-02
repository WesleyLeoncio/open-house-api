package wl.open_house_api.model.categoria.request;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import wl.open_house_api.model.categoria.enuns.Category;

public record CategoriaRequest(@NotNull Long id, @NotNull @Valid() Category nome) {
}
