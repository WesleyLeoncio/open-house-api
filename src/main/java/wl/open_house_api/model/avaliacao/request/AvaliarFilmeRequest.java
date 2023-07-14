package wl.open_house_api.model.avaliacao.request;
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
