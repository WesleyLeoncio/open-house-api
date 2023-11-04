package wl.open_house_api.modules.usuario.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestCreatUser(@NotBlank String nome, @NotBlank @Email String login, @NotBlank String senha) {
}
