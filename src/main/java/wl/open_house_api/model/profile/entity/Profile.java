package wl.open_house_api.model.profile.entity;

import jakarta.persistence.*;
import wl.open_house_api.model.role.entity.Role;
import wl.open_house_api.model.usuario.entity.Usuario;

import java.io.Serializable;


@Table(name = "profiles")
@Entity(name = "Profile")
public class Profile implements Serializable {
    @EmbeddedId
    ProfileId profileId;
    @ManyToOne
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private Role role;


    public Profile() {
    }

    public Profile(ProfileId profileId, Usuario usuario, Role role) {
        this.profileId = profileId;
        this.usuario = usuario;
        this.role = role;
    }

    public ProfileId getProfileId() {
        return profileId;
    }

    public void setProfileId(ProfileId profileId) {
        this.profileId = profileId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Profile{" +
               "profileId=" + profileId +
               ", usuario=" + usuario +
               ", role=" + role +
               '}';
    }
}
