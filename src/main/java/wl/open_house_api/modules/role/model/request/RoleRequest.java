package wl.open_house_api.modules.role.model.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import wl.open_house_api.modules.role.model.enuns.Roles;

public record RoleRequest(@NotNull Long id, @NotNull @Valid() Roles nome) {
}
