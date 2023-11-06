package wl.open_house_api.modules.filme.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wl.open_house_api.modules.filme.factory.FilmeFactory;
import wl.open_house_api.modules.filme.model.entity.Filme;
import wl.open_house_api.modules.filme.model.mapper.FilmeMapper;
import wl.open_house_api.modules.filme.model.response.FilmeResponse;
import wl.open_house_api.modules.filme.model.response.FilmeResponseCategoriaFilme;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FilmeMapperTest {

    private FilmeFactory filmeFactory;
    @BeforeEach
    public void beforeEach(){
        this.filmeFactory = new FilmeFactory();
    }

    @Test
    @DisplayName("Deveria converter um FilmeRequestCreat em uma entity Filme")
    void filmeRequestCreatToFilme() {
        Filme filme = FilmeMapper.INSTANCE.filmeRequestCreatToFilme(filmeFactory.getFilmeRequestCreat());

        //then
        assertThat( filme ).isNotNull();
        assertThat( filme.getNome()).isEqualTo( "FILME 1" );
        assertThat( filme.getDescricao()).isEqualTo( "DESCRICAO" );
        assertThat( filme.getDataLancamento()).isEqualTo(LocalDate.now());
        assertThat( filme.getDuracao()).isEqualTo( "120 m" );
        assertThat( filme.getImagem()).isEqualTo( "imagem.png" );
    }

  @Test
    @DisplayName("Deveria converter um FilmeRequestEdit em uma entity Filme")
    void filmeRequestEditToFilme() {

        Filme filme = FilmeMapper.INSTANCE.filmeRequestEditToFilme(filmeFactory.getFilmeRequestEdit());

        //then
        assertThat( filme ).isNotNull();
        assertThat( filme.getId()).isEqualTo( 1L );
        assertThat( filme.getNome()).isEqualTo( "FILME 1" );
        assertThat( filme.getDescricao()).isEqualTo( "DESCRICAO" );
        assertThat( filme.getDataLancamento()).isEqualTo(LocalDate.now());
        assertThat( filme.getDuracao()).isEqualTo( "120 m" );
        assertThat( filme.getImagem()).isEqualTo( "imagem.png" );
    }


    @Test
    @DisplayName("Deveria converter um Filme em uma entity FilmeResponse")
    void filmeToFilmeResponse() {

        FilmeResponse filmeResponse = FilmeMapper.INSTANCE.filmeToFilmeResponse(filmeFactory.getFilme());

        //then
        assertThat( filmeResponse ).isNotNull();
        assertThat( filmeResponse.id()).isEqualTo( 1L );
        assertThat( filmeResponse.nome()).isEqualTo( "FILME 1" );
        assertThat( filmeResponse.descricao()).isEqualTo( "DESCRICAO" );
        assertThat( filmeResponse.dataLancamento()).isEqualTo(LocalDate.now());
        assertThat( filmeResponse.duracao()).isEqualTo( "120 m" );
        assertThat( filmeResponse.imagem()).isEqualTo( "imagem.png" );
    }

   @Test
    @DisplayName("Deveria converter um Filme em uma entity FilmeResponseCategoriaFilme")
    void filmeToFilmeListResponse() {

       FilmeResponseCategoriaFilme filmeListResponse = FilmeMapper.INSTANCE.filmeToFilmeResponseCategoriaFilme(filmeFactory.getFilme());

        //then
        assertThat( filmeListResponse ).isNotNull();
        assertThat( filmeListResponse.id()).isEqualTo( 1L );
        assertThat( filmeListResponse.nome()).isEqualTo( "FILME 1" );

    }
}