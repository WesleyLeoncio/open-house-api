package wl.open_house_api.model.profile.request;

import jakarta.validation.constraints.NotNull;

public record ProfileRequestUser(@NotNull Long usuarioId) {
}
