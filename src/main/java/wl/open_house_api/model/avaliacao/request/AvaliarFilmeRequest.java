package wl.open_house_api.model.avaliacao.request;

import jakarta.validation.constraints.NotNull;
import wl.open_house_api.model.filme.entity.Filme;
import wl.open_house_api.model.usuario.entity.Usuario;

public record AvaliarFilmeRequest(
        @NotNull
        Filme filme,

        @NotNull
        Usuario usuario,

        @NotNull
        int nota

) {
}
