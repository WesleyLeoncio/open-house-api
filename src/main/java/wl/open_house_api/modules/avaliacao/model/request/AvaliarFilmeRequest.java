package wl.open_house_api.modules.avaliacao.model.request;
import jakarta.validation.constraints.NotNull;

public record AvaliarFilmeRequest(
        @NotNull
        Long idFilme,

        @NotNull
        Long idUsuario,

        @NotNull
        int nota

) {
}
