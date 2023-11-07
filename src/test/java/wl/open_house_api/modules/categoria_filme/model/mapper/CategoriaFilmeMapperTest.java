package wl.open_house_api.modules.categoria_filme.model.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wl.open_house_api.modules.categoria_filme.factory.CategoriaFilmeFactory;
import wl.open_house_api.modules.categoria_filme.model.response.CategoriaFilmeResponse;


import static org.assertj.core.api.Assertions.assertThat;


class CategoriaFilmeMapperTest {

    @Test
    @DisplayName("Deveria converter uma categoriaFilme em uma CategoriaFilmeResponse")
    void categoriaFilmeToCategoriaFilmeResponse() {

        CategoriaFilmeFactory categoriaFilmeFactory = new CategoriaFilmeFactory();

        CategoriaFilmeResponse response =
                CategoriaFilmeMapper.INSTANCE.categoriaFilmeToCategoriaFilmeResponse(categoriaFilmeFactory.getCategoriaFilme());

        assertThat(response).isNotNull();
        assertThat( response.filme().id()).isEqualTo( 1L );
        assertThat( response.categoria().nome()).isEqualTo( "ACAO" );
    }
}