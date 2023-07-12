package wl.open_house_api.model.profile.request;

import jakarta.validation.constraints.NotBlank;

public record ProfileRequestCreat(@NotBlank String nome) {
}
