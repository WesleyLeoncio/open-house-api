package wl.open_house_api.modules.categoria.model.request;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import wl.open_house_api.modules.categoria.model.enuns.Category;

public record CategoriaRequest(@NotNull @Valid() Category nome) {
}
