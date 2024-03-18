package wl.open_house_api.modules.categoria.model.response;


import java.io.Serializable;
import java.util.UUID;

public record CategoriaResponse(UUID id, String nome) implements Serializable {
}
