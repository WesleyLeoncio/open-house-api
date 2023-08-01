package wl.open_house_api.model.role.request;

import jakarta.validation.constraints.NotNull;

public record RoleRequest(@NotNull Long id, String nome) {
}
