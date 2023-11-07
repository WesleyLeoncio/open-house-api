package wl.open_house_api.modules.categoria.model.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wl.open_house_api.modules.categoria.factory.CategoriaFactory;
import wl.open_house_api.modules.categoria.model.entiy.Categoria;
import wl.open_house_api.modules.categoria.model.enuns.Category;
import wl.open_house_api.modules.categoria.model.response.CategoriaResponse;
import wl.open_house_api.modules.categoria.model.response.CategoriaResponseId;

import static org.assertj.core.api.Assertions.assertThat;


class CategoriaMapperTest {

    private CategoriaFactory categoriaFactory;

    @BeforeEach
    public void beforeEach (){
        this.categoriaFactory = new CategoriaFactory();
    }

    @Test
    @DisplayName("Deveria converter um CategoriaRequestCreat em uma entity Categoria")
    void categoriaRequestCreatToCategoria(){
        Categoria categoria = CategoriaMapper.INSTANCE.categoriaRequestCreatToCategoria
                (categoriaFactory.getCategoriaRequestCreat());

        assertThat(categoria).isNotNull();
        assertThat(categoria.getNome()).isEqualTo(Category.ACAO);
    }

    @Test
    @DisplayName("Deveria converter um CategoriaRequest em uma entity Categoria")
    void categoriaRequestToCategoria(){
        Categoria categoria = CategoriaMapper.INSTANCE.categoriaRequestToCategoria
                (categoriaFactory.getCategoriaRequest());

        assertThat(categoria).isNotNull();
        assertThat(categoria.getId()).isEqualTo(1L);
        assertThat(categoria.getNome()).isEqualTo(Category.ACAO);
    }


    @Test
    @DisplayName("Deveria converter um entity Categoria em uma  CategoriaResponse")
    void categoriaToCategoriaResponse(){
        CategoriaResponse categoriaResponse = CategoriaMapper.INSTANCE.categoriaToCategoriaResponse
                (categoriaFactory.getCategoria());

        assertThat(categoriaResponse).isNotNull();
        assertThat(categoriaResponse.nome()).isEqualTo("ACAO");

    }

    @Test
    @DisplayName("Deveria converter um entity Categoria em uma  CategoriaResponseId")
    void categoriaToCategoriaResponseId(){
        CategoriaResponseId categoriaResponseId = CategoriaMapper.INSTANCE.categoriaToCategoriaResponseId
                (categoriaFactory.getCategoria());

        assertThat(categoriaResponseId).isNotNull();
        assertThat(categoriaResponseId.id()).isEqualTo(1L);
        assertThat(categoriaResponseId.nome()).isEqualTo("ACAO");

    }

}