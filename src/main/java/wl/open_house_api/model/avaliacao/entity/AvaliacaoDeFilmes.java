package wl.open_house_api.model.avaliacao.entity;

import jakarta.persistence.*;
import wl.open_house_api.model.filme.entity.Filme;
import wl.open_house_api.model.usuario.entity.Usuario;

import java.io.Serializable;

@Table(name = "avaliacoes")
@Entity(name="AvaliacaoDeFilmes")
public class AvaliacaoDeFilmes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filme filme;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private int nota;


    public AvaliacaoDeFilmes() {
    }

    public AvaliacaoDeFilmes(Long id, Filme filme, Usuario usuario, int nota) {
        this.id = id;
        this.filme = filme;
        this.usuario = usuario;
        this.nota = nota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
