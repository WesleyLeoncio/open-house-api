package wl.open_house_api.model.profile.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProfileRequestEdit(@NotNull Long id, @NotBlank String nome) {
}
