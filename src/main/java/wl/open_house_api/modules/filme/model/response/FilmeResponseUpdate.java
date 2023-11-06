package wl.open_house_api.modules.filme.model.response;

import java.time.LocalDate;

public record FilmeResponseUpdate(
        Long id,
        String nome,
        String descricao,
        LocalDate dataLancamento,
        String duracao,
        String imagem
) {
}