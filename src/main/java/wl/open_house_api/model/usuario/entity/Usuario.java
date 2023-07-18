package wl.open_house_api.model.usuario.entity;
import jakarta.persistence.*;
import wl.open_house_api.model.role.entity.Role;
import wl.open_house_api.model.usuario.request.UsuarioRequestEditMaster;

import java.io.Serializable;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String login;
    private String senha;

    @ManyToMany
    @JoinTable(name = "profiles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> role;

    private Boolean status;

    public Usuario() {
        this.status = true;
    }

    public Usuario(Long id, String nome, String login, String senha, List<Role> role) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.role = role;
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

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public void atualizarDados(UsuarioRequestEditMaster user){
        setNome(user.nome());
        setLogin(user.login());
        setSenha(user.senha());
    }

    @Override
    public String toString() {
        return "Usuario{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", login='" + login + '\'' +
               ", senha='" + senha + '\'' +
               ", role=" + role +
               ", status=" + status +
               '}';
    }
}
