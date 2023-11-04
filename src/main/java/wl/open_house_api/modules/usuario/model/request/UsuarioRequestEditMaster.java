package wl.open_house_api.modules.usuario.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public record UsuarioRequestEditMaster(

        @NotNull
        Long id,

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String login,

        @NotBlank
        String senha
) {
}
