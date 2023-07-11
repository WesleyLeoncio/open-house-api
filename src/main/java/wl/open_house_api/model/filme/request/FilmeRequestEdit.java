package wl.open_house_api.model.filme.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import wl.open_house_api.model.filme.enuns.Categoria;

import java.time.LocalDate;

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
        @NotNull @Valid()
        Categoria categoria
) {


}
