package wl.open_house_api.modules.filme.factory;

import wl.open_house_api.modules.categoria.factory.CategoriaFactory;
import wl.open_house_api.modules.filme.model.entity.Filme;
import wl.open_house_api.modules.filme.model.request.FilmeRequestCreat;
import wl.open_house_api.modules.filme.model.request.FilmeRequestEdit;
import wl.open_house_api.modules.filme.model.response.FilmeResponse;

import java.time.LocalDate;
import java.util.UUID;


public class FilmeFactory {

    private final UUID id;
    private final String nome;
    private final String descricao;
    private final LocalDate data;
    private final String duracao;
    private final String imagem;
    CategoriaFactory categoriaFactory = new CategoriaFactory();

    public FilmeFactory() {
        this.id = UUID.fromString("09b231da-8189-45ba-936c-65c32beaecb1");
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
                this.nome, this.descricao, this.data, this.duracao, this.imagem, this.categoriaFactory.getCategoriaFilme());
    }

    public FilmeRequestEdit getFilmeRequestEdit(){
        return new FilmeRequestEdit(
                this.nome, this.descricao, this.data, this.duracao, this.imagem,this.categoriaFactory.getCategoriaFilme());
    }


    public FilmeResponse getFilmeResponse(){
        return new FilmeResponse(this.id, this.nome, this.descricao, this.data, this.duracao, this.imagem,this.categoriaFactory.categoriaResponseList());
    }



}
