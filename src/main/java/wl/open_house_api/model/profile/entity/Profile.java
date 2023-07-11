package wl.open_house_api.model.profile.entity;

import jakarta.persistence.*;

@Table(name = "profiles")
@Entity(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Profile(){}

    public Profile(String nome) {
        this.nome = nome;
    }
}
