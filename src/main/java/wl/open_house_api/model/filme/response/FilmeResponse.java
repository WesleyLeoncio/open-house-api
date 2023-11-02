package wl.open_house_api.model.filme.response;

import wl.open_house_api.model.categoria.response.CategoriaResponse;

import java.time.LocalDate;
import java.util.List;

public record FilmeResponse(
        Long id,
        String nome,
        String descricao,
        LocalDate dataLancamento,
        String duracao,
        String imagem,
        List<CategoriaResponse> categorias
)
{
}
