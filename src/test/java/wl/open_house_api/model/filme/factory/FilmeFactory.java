package wl.open_house_api.model.filme.factory;

import wl.open_house_api.model.filme.entity.Filme;
import wl.open_house_api.model.filme.enuns.Categoria;
import wl.open_house_api.model.filme.request.FilmeRequestCreat;
import wl.open_house_api.model.filme.request.FilmeRequestEdit;

import java.time.LocalDate;

public class FilmeFactory {

    private final Long id;
    private final String nome;
    private final String descricao;
    private final LocalDate data;
    private final String duracao;
    private final String imagem;
    private final Categoria categoria;


    public FilmeFactory() {
        this.id = 1L;
        this.nome = "FILME 1";
        this.descricao = "DESCRICAO";
        this.data = LocalDate.now();
        this.duracao = "120 m";
        this.imagem = "imagem.png";
        this.categoria = Categoria.ACAO;
    }

    public Filme getFilme(){
        return new Filme(this.id, this.nome, this.descricao, this.data, this.duracao,
                this.imagem, this.categoria);
    }

    public FilmeRequestCreat getFilmeRequestCreat(){
        return new FilmeRequestCreat(
                this.nome, this.descricao, this.data, this.duracao, this.imagem, this.categoria);
    }

    public FilmeRequestEdit getFilmeRequestEdit(){
        return new FilmeRequestEdit(
                this.id, this.nome, this.descricao, this.data, this.duracao, this.imagem, this.categoria);
    }


}
