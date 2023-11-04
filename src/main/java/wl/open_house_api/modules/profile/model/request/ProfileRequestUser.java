package wl.open_house_api.modules.profile.model.request;

import jakarta.validation.constraints.NotNull;

public record ProfileRequestUser(@NotNull Long usuarioId) {
}
