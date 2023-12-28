package wl.open_house_api.modules.filme.model.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import wl.open_house_api.modules.categoria.model.request.CategoriaRequest;

import java.time.LocalDate;
import java.util.List;


public record FilmeRequestEdit(
        @NotNull
        Long id,

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
        List<CategoriaRequest> categorias
) {


}
