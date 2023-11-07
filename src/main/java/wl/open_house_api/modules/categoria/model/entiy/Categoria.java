package wl.open_house_api.modules.categoria.model.entiy;

import jakarta.persistence.*;
import wl.open_house_api.modules.categoria.model.enuns.Category;

import java.io.Serializable;

@Table(name = "categorias")
@Entity(name = "Categoria")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Category nome;


    public Categoria() {
    }

    public Categoria(Long id, Category nome) {
        this.id = id;
        this.nome = nome;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getNome() {
        return nome;
    }

    public void setNome(Category nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Categoria{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               '}';
    }
}
