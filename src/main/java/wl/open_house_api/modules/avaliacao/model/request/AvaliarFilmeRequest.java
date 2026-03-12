package wl.open_house_api.modules.avaliacao.model.request;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AvaliarFilmeRequest(
        @NotNull
        UUID idFilme,

        @NotNull
        int nota
) {
}
