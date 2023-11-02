package wl.open_house_api.model.categoria_filme.entity;

import jakarta.persistence.*;
import wl.open_house_api.model.categoria.entiy.Categoria;
import wl.open_house_api.model.filme.entity.Filme;

import java.io.Serializable;


@Table(name = "categoria_filme")
@Entity(name = "Categoria_Filme")
public class CategoriaFilme implements Serializable {

    @EmbeddedId
    CategoriaFilmeId categoriaFilmeId;

    @ManyToOne
    @MapsId("filmeId")
    @JoinColumn(name = "filme_id")
    private Filme filme;

    @ManyToOne
    @MapsId("categoriaId")
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public CategoriaFilme() {
    }

    public CategoriaFilme(CategoriaFilmeId categoriaFilmeId, Filme filme, Categoria categoria) {
        this.categoriaFilmeId = categoriaFilmeId;
        this.filme = filme;
        this.categoria = categoria;
    }

    public CategoriaFilmeId getCategoriaFilmeId() {
        return categoriaFilmeId;
    }

    public void setCategoriaFilmeId(CategoriaFilmeId categoriaFilmeId) {
        this.categoriaFilmeId = categoriaFilmeId;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "CategoriaFilme{" +
               "categoriaFilmeId=" + categoriaFilmeId +
               ", filme=" + filme +
               ", categoria=" + categoria +
               '}';
    }
}
