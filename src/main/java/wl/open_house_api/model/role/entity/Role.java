package wl.open_house_api.model.role.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@Table(name = "roles")
@Entity(name = "Role")
public class Role implements GrantedAuthority,Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //TODO MODIFICAR PARA ENUM
    private String nome;

    public Role(){}

    public Role(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String getAuthority() {
        return getNome();
    }

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

    @Override
    public String toString() {
        return "Role{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               '}';
    }


}
