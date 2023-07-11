package wl.open_house_api.model.filme.response;

import wl.open_house_api.model.filme.enuns.Categoria;
import wl.open_house_api.model.filme.entity.Filme;

import java.time.LocalDate;

public record FilmeListResponse(
        Long id,
        String nome,
        LocalDate dataLancamento,
        String duracao,
        String imagem,
        Categoria categoria
) {
    public FilmeListResponse(Filme filme){
        this(filme.getId(), filme.getNome(),filme.getDataLancamento(),filme.getDuracao(),filme.getImagem(),filme.getCategoria());
    }

}
