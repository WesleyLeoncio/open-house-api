package wl.open_house_api.modules.filme.factory;

import wl.open_house_api.modules.categoria.model.response.CategoriaResponse;
import wl.open_house_api.modules.categoria_filme.model.request.CategoriaFilmeRequestCategoria;
import wl.open_house_api.modules.filme.model.entity.Filme;
import wl.open_house_api.modules.filme.model.request.FilmeRequestCreat;
import wl.open_house_api.modules.filme.model.request.FilmeRequestEdit;
import wl.open_house_api.modules.filme.model.response.FilmeResponse;
import wl.open_house_api.modules.filme.model.response.FilmeResponseCreat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FilmeFactory { //TODO ARRUMAR TESTES

    private final Long id;
    private final String nome;
    private final String descricao;
    private final LocalDate data;
    private final String duracao;
    private final String imagem;
    List<CategoriaFilmeRequestCategoria> categoriaList = new ArrayList<>();

    public FilmeFactory() {
        this.id = 1L;
        this.nome = "FILME 1";
        this.descricao = "DESCRICAO";
        this.data = LocalDate.now();
        this.duracao = "120 m";
        this.imagem = "imagem.png";
        this.categoriaList.add(new CategoriaFilmeRequestCategoria(1L));
    }

    public Filme getFilme(){
        return new Filme(this.id, this.nome, this.descricao, this.data, this.duracao,
                this.imagem);
    }

    public FilmeRequestCreat getFilmeRequestCreat(){
        return new FilmeRequestCreat(
                this.nome, this.descricao, this.data, this.duracao, this.imagem, this.categoriaList);
    }

    public FilmeRequestEdit getFilmeRequestEdit(){
        return new FilmeRequestEdit(
                this.id, this.nome, this.descricao, this.data, this.duracao, this.imagem);
    }

    public FilmeResponse getFilmeResponse(){
        return new FilmeResponse(this.id, this.nome, this.descricao, this.data, this.duracao, this.imagem,this.getListCategoriaResponse());
    }

    public FilmeResponseCreat getFilmeResponseCreat(){
        return new FilmeResponseCreat(this.id, this.nome, this.descricao, this.data, this.duracao, this.imagem);
    }


    public  List<CategoriaResponse> getListCategoriaResponse(){
        List<CategoriaResponse> listCategoriaResponse = new ArrayList<>();
        listCategoriaResponse.add(new CategoriaResponse("AÇÃO"));
        return listCategoriaResponse;
    }

}
