package wl.open_house_api.model.filme.response;

import wl.open_house_api.model.filme.enuns.Categoria;
import wl.open_house_api.model.filme.entity.Filme;

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
    public FilmeResponse(Filme filme){
        this(filme.getId(), filme.getNome(),filme.getDescricao(),filme.getDataLancamento(),filme.getDuracao(),filme.getImagem(),filme.getCategoria());
    }
}
