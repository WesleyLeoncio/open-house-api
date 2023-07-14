package wl.open_house_api.model.usuario.request;

import jakarta.validation.constraints.NotNull;

public record UsuarioRequestModifyStatus(@NotNull Long id) {
}
