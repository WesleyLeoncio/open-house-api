package wl.open_house_api.modules.role.model.request;

import jakarta.validation.constraints.NotBlank;

public record RoleRequestCreat(@NotBlank String nome) {
}
