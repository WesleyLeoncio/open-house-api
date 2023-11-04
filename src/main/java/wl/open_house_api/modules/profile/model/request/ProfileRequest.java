package wl.open_house_api.modules.profile.model.request;

import jakarta.validation.constraints.NotNull;

public record ProfileRequest(@NotNull Long usuarioId, @NotNull Long roleId) {
}
