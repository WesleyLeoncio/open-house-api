package wl.open_house_api.model.profile.request;

import jakarta.validation.constraints.NotNull;

public record ProfileRequest(@NotNull Long id, String nome) {
}
