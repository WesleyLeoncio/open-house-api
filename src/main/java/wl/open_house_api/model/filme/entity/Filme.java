package wl.open_house_api.model.filme.entity;


import jakarta.persistence.*;
import wl.open_house_api.model.filme.enuns.Categoria;

import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "filmes")
@Entity(name = "Filme")
public class Filme implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private LocalDate dataLancamento;
    private String duracao;
    private String imagem;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Filme() {}

    public Filme(Long id, String nome, String descricao, LocalDate dataLancamento, String duracao, String imagem, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataLancamento = dataLancamento;
        this.duracao = duracao;
        this.imagem = imagem;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
