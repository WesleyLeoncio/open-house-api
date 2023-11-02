package wl.open_house_api.model.filme.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import wl.open_house_api.model.categoria_filme.request.CategoriaFilmeRequestCategoria;

import java.time.LocalDate;
import java.util.List;

public record FilmeRequestCreat(
        @NotBlank
        String nome,

        @NotBlank
        String descricao,

        @NotNull
        LocalDate dataLancamento,

        @NotBlank
        String duracao,

        @NotBlank
        String imagem,

        @NotNull
        List<CategoriaFilmeRequestCategoria> categoriaList
) {


}
