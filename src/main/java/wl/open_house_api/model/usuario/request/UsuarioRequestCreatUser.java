package wl.open_house_api.model.usuario.request;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestCreatUser(@NotBlank String nome, @NotBlank String login, @NotBlank String senha) {
}
