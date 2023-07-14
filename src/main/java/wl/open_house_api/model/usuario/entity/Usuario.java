package wl.open_house_api.model.usuario.entity;

import jakarta.persistence.*;

import wl.open_house_api.model.profile.entity.Profile;

@Table(name = "usuarios")
@Entity(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String login;
    private String senha;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    private Boolean status;

    public Usuario() {
        this.status = true;
    }

    public Usuario(Long id, String nome, String login, String senha, Profile profile) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.profile = profile;
        this.status = true;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
