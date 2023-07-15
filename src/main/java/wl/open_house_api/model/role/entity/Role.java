package wl.open_house_api.model.role.entity;

import jakarta.persistence.*;

@Table(name = "roles")
@Entity(name = "Role")
public class Role { //TODO VERIFICAR IMPLEMTACAO VERIFICAR NO VIDEO
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Role(){}

    public Role(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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
}
