package wl.open_house_api.modules.filme.model.response;

import wl.open_house_api.modules.categoria.model.response.CategoriaResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record FilmeResponse(
        UUID id,
        String nome,
        String descricao,
        LocalDate dataLancamento,
        String duracao,
        String imagem,
        List<CategoriaResponse> categorias
)
{
}
