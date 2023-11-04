package wl.open_house_api.modules.usuario.model.request;

import jakarta.validation.constraints.NotNull;

public record UsuarioRequestModifyStatus(@NotNull Long id) {
}
