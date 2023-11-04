package wl.open_house_api.modules.profile.model.request;

import jakarta.validation.constraints.NotNull;

public record ProfileRequestRole(@NotNull Long roleId) {
}
