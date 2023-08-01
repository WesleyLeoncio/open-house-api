package wl.open_house_api.model.filme.response;

import wl.open_house_api.model.filme.enuns.Categoria;
import java.time.LocalDate;

public record FilmeResponse(
        Long id,
        String nome,
        String descricao,
        LocalDate dataLancamento,
        String duracao,
        String imagem,
        Categoria categoria
)
{
}
