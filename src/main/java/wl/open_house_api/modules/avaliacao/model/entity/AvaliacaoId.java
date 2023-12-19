package wl.open_house_api.modules.avaliacao.model.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AvaliacaoId implements Serializable {

    private Long filmeId;

    private Long usuarioId;

    public AvaliacaoId() {
    }

    public AvaliacaoId(Long filmeId, Long usuarioId) {
        this.filmeId = filmeId;
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AvaliacaoId that = (AvaliacaoId) o;

        if (!Objects.equals(filmeId, that.filmeId)) return false;
        return Objects.equals(usuarioId, that.usuarioId);
    }

    @Override
    public int hashCode() {
        int result = filmeId != null ? filmeId.hashCode() : 0;
        result = 31 * result + (usuarioId != null ? usuarioId.hashCode() : 0);
        return result;
    }
}
