package wl.open_house_api.model.profile.response;

import jakarta.validation.constraints.NotNull;

public record ProfileResponse(@NotNull Long usuarioId, @NotNull Long roleId) {
}
