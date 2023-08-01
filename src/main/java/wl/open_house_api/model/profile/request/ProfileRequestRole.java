package wl.open_house_api.model.profile.request;

import jakarta.validation.constraints.NotNull;

public record ProfileRequestRole(@NotNull Long roleId) {
}
