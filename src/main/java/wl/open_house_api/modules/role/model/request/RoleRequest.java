package wl.open_house_api.modules.role.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RoleRequest(@NotNull Long id, @NotBlank String nome) {
}
