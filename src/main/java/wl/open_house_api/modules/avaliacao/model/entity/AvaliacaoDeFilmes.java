package wl.open_house_api.modules.avaliacao.model.entity;

import jakarta.persistence.*;
import wl.open_house_api.modules.filme.model.entity.Filme;
import wl.open_house_api.modules.usuario.model.entity.Usuario;

import java.io.Serializable;

@Table(name = "avaliacoes")
@Entity(name="AvaliacaoDeFilmes")
public class AvaliacaoDeFilmes implements Serializable {

    @EmbeddedId
    AvaliacaoId avaliacaoId;

    @ManyToOne
    @MapsId("filmeId")
    @JoinColumn(name = "filme_id")
    private Filme filme;

    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private int nota;

    public AvaliacaoDeFilmes() {}

    public AvaliacaoDeFilmes(AvaliacaoId avaliacaoId, Filme filme, Usuario usuario, int nota) {
        this.avaliacaoId = avaliacaoId;
        this.filme = filme;
        this.usuario = usuario;
        this.nota = nota;
    }

    public AvaliacaoId getAvaliacaoId() {
        return avaliacaoId;
    }

    public void setAvaliacaoId(AvaliacaoId avaliacaoId) {
        this.avaliacaoId = avaliacaoId;
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
