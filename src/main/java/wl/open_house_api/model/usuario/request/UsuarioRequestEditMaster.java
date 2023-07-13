package wl.open_house_api.model.usuario.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import wl.open_house_api.model.profile.entity.Profile;

public record UsuarioRequestEditMaster(

        @NotNull
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String login,
        @NotBlank
        String senha,
        @NotNull @Valid()
        Profile profile,
        @NotNull
        Boolean status

) {
}
