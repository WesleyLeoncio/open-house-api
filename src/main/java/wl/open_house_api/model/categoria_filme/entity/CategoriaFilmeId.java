package wl.open_house_api.model.categoria_filme.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CategoriaFilmeId implements Serializable {

    private Long filmeId;

    private Long categoriaId;

    public CategoriaFilmeId() {
    }

    public CategoriaFilmeId(Long filmeId, Long categoriaId) {
        this.filmeId = filmeId;
        this.categoriaId = categoriaId;
    }

    public Long getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(Long filmeId) {
        this.filmeId = filmeId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoriaFilmeId that)) return false;

        if (!filmeId.equals(that.filmeId)) return false;
        return categoriaId.equals(that.categoriaId);
    }

    @Override
    public int hashCode() {
        int result = filmeId.hashCode();
        result = 31 * result + categoriaId.hashCode();
        return result;
    }
}
