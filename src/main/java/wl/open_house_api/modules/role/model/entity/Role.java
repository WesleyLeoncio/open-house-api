package wl.open_house_api.modules.role.model.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import wl.open_house_api.modules.role.model.enuns.Roles;

import java.io.Serializable;

@Table(name = "roles")
@Entity(name = "Role")
public class Role implements GrantedAuthority,Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Roles nome;

    public Role(){}

    public Role(Long id, Roles nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String getAuthority() {
        return getNome().toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
