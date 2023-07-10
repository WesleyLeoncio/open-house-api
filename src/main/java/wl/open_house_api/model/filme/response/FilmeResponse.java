package wl.open_house_api.model.filme.response;

import wl.open_house_api.model.filme.Categoria;
import wl.open_house_api.model.filme.entity.Filme;

import java.util.Date;

public record FilmeResponse(
        Long id,
        String nome,
        String descricao,
        Date dataLancamento,
        String duracao,
        String imagem,
        Categoria categoria
)
{
    public FilmeResponse(Filme filme){
        this(filme.getId(), filme.getNome(),filme.getDescricao(),filme.getDataLancamento(),filme.getDuracao(),filme.getDuracao(),filme.getCategoria());
    }
}
