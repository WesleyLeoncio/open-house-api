package wl.open_house_api.model.role.request;

import jakarta.validation.constraints.NotBlank;

public record RoleRequestCreat(@NotBlank String nome) {
}
