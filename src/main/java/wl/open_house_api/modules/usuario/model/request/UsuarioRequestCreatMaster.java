package wl.open_house_api.modules.usuario.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import wl.open_house_api.modules.profile.model.request.ProfileRequestRole;

import java.util.List;

public record UsuarioRequestCreatMaster(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String login,

        @NotBlank
        String senha,

        @NotNull
        List<ProfileRequestRole> rolesList


) {

}
