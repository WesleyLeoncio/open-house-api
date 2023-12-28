package wl.open_house_api.modules.filme.factory;

import wl.open_house_api.modules.categoria.factory.CategoriaFactory;
import wl.open_house_api.modules.categoria.model.enuns.Category;
import wl.open_house_api.modules.categoria.model.request.CategoriaRequest;
import wl.open_house_api.modules.categoria.model.response.CategoriaResponse;
import wl.open_house_api.modules.filme.model.entity.Filme;
import wl.open_house_api.modules.filme.model.request.FilmeRequestCreat;
import wl.open_house_api.modules.filme.model.request.FilmeRequestEdit;
import wl.open_house_api.modules.filme.model.response.FilmeResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class FilmeFactory {

    private final Long id;
    private final String nome;
    private final String descricao;
    private final LocalDate data;
    private final String duracao;
    private final String imagem;

    public FilmeFactory() {
        this.id = 1L;
        this.nome = "FILME 1";
        this.descricao = "DESCRICAO";
        this.data = LocalDate.now();
        this.duracao = "120 m";
        this.imagem = "imagem.png";
    }

    public Filme getFilme(){
        return new Filme(this.id, this.nome, this.descricao, this.data, this.duracao,
                this.imagem);
    }

    public FilmeRequestCreat getFilmeRequestCreat(){
        return new FilmeRequestCreat(
                this.nome, this.descricao, this.data, this.duracao, this.imagem, this.categoriaList());
    }

    public FilmeRequestEdit getFilmeRequestEdit(){
        return new FilmeRequestEdit(
                this.id, this.nome, this.descricao, this.data, this.duracao, this.imagem,this.categoriaList());
    }


    public FilmeResponse getFilmeResponse(){
        CategoriaFactory categoriaFactory = new CategoriaFactory();
        return new FilmeResponse(this.id, this.nome, this.descricao, this.data, this.duracao, this.imagem,this.categoriaResponseList());
    }

    private List<CategoriaRequest> categoriaList(){
        CategoriaRequest categoriaRequest = new CategoriaRequest(1L, Category.ACAO);
        List<CategoriaRequest> listCategoria = new ArrayList<>();
        listCategoria.add(categoriaRequest);
        return  listCategoria;
    }


    private List<CategoriaResponse> categoriaResponseList (){
        CategoriaFactory categoriaFactory = new CategoriaFactory();
        List<CategoriaResponse> listCategoriasResponse = new ArrayList<>();
        listCategoriasResponse.add(categoriaFactory.getCategoriaResponse());
        return listCategoriasResponse;
    }

}
