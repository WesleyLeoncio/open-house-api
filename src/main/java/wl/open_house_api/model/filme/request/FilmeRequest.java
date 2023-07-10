package wl.open_house_api.model.filme.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import wl.open_house_api.model.filme.Categoria;

import java.util.Date;

public record FilmeRequest(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotBlank
        Date dataLancamento,
        @NotBlank
        String duracao,
        @NotBlank
        String imagem,
        @NotNull @Valid
        Categoria categoria
) {


}
