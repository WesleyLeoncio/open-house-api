package wl.open_house_api.model.autenticacao.request;

import jakarta.validation.constraints.NotBlank;

public record UsuarioAtenticaoRequest(
        @NotBlank
        String login,
        @NotBlank
        String senha
) {
}
