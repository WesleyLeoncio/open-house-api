package wl.open_house_api.modules.role.model.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import wl.open_house_api.modules.role.model.enuns.Roles;

import java.io.Serializable;
import java.util.UUID;

@Table(name = "roles")
@Entity(name = "Role")
public class Role implements GrantedAuthority,Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private Roles nome;

    public Role(){}

    public Role(UUID id, Roles nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String getAuthority() {
        return getNome().toString();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Roles getNome() {
        return nome;
    }

    public void setNome(Roles nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Role{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               '}';
    }


}
