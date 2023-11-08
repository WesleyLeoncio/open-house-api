package wl.open_house_api.modules.profile.model.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ProfileId implements Serializable {

    private Long usuarioId;

    private Long roleId;

    public ProfileId() {
    }

    public ProfileId(Long usuarioId, Long roleId) {
        this.usuarioId = usuarioId;
        this.roleId = roleId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfileId profileId)) return false;

        if (!usuarioId.equals(profileId.usuarioId)) return false;
        return roleId.equals(profileId.roleId);
    }

    @Override
    public int hashCode() {
        int result = usuarioId.hashCode();
        result = 31 * result + roleId.hashCode();
        return result;
    }
}
