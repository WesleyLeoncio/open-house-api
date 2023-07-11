package wl.open_house_api.model.filme.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import wl.open_house_api.model.filme.Categoria;
import wl.open_house_api.model.filme.request.FilmeRequest;
import java.time.LocalDate;

@EqualsAndHashCode(of = "id")
@Table(name = "filmes")
@Entity(name = "Filme")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @JsonProperty("data_lancamento")
    private LocalDate dataLancamento;
    private String duracao;
    private String imagem;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Filme(FilmeRequest filmeRequest) {
        setId(null);
        setNome(filmeRequest.nome());
        setDescricao(filmeRequest.descricao());
        setDataLancamento(filmeRequest.dataLancamento());
        setDuracao(filmeRequest.duracao());
        setImagem(filmeRequest.imagem());
        setCategoria(filmeRequest.categoria());
    }


    public Filme() {}

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
