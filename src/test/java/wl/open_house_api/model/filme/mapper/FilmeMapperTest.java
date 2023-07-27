package wl.open_house_api.model.filme.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wl.open_house_api.model.filme.entity.Filme;
import wl.open_house_api.model.filme.enuns.Categoria;
import wl.open_house_api.model.filme.factory.FilmeFactory;
import wl.open_house_api.model.filme.response.FilmeListResponse;
import wl.open_house_api.model.filme.response.FilmeResponse;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FilmeMapperTest {

    @Test
    @DisplayName("Deveria converter um FilmeRequestCreat em uma entity Filme")
    void filmeRequestCreatToFilmeCenario() {
        FilmeFactory filmeFactory = new FilmeFactory();

        Filme filme = FilmeMapper.INSTANCE.filmeRequestCreatToFilme(filmeFactory.getFilmeRequestCreat());

        //then
        assertThat( filme ).isNotNull();
        assertThat( filme.getNome()).isEqualTo( "FILME 1" );
        assertThat( filme.getDescricao()).isEqualTo( "DESCRICAO" );
        assertThat( filme.getDataLancamento()).isEqualTo(LocalDate.now());
        assertThat( filme.getDuracao()).isEqualTo( "120 m" );
        assertThat( filme.getImagem()).isEqualTo( "imagem.png" );
        assertThat( filme.getCategoria()).isEqualTo( Categoria.ACAO );
    }

    @Test
    @DisplayName("Deveria converter um FilmeRequestEdit em uma entity Filme")
    void filmeRequestEditToFilme() {
        FilmeFactory filmeFactory = new FilmeFactory();

        Filme filme = FilmeMapper.INSTANCE.filmeRequestEditToFilme(filmeFactory.getFilmeRequestEdit());

        //then
        assertThat( filme ).isNotNull();
        assertThat( filme.getId()).isEqualTo( 1L );
        assertThat( filme.getNome()).isEqualTo( "FILME 1" );
        assertThat( filme.getDescricao()).isEqualTo( "DESCRICAO" );
        assertThat( filme.getDataLancamento()).isEqualTo(LocalDate.now());
        assertThat( filme.getDuracao()).isEqualTo( "120 m" );
        assertThat( filme.getImagem()).isEqualTo( "imagem.png" );
        assertThat( filme.getCategoria()).isEqualTo( Categoria.ACAO );
    }

    @Test
    @DisplayName("Deveria converter um Filme em uma entity FilmeResponse")
    void filmeToFilmeResponse() {
        FilmeFactory filmeFactory = new FilmeFactory();

        FilmeResponse filmeResponse = FilmeMapper.INSTANCE.filmeToFilmeResponse(filmeFactory.getFilme());

        //then
        assertThat( filmeResponse ).isNotNull();
        assertThat( filmeResponse.id()).isEqualTo( 1L );
        assertThat( filmeResponse.nome()).isEqualTo( "FILME 1" );
        assertThat( filmeResponse.descricao()).isEqualTo( "DESCRICAO" );
        assertThat( filmeResponse.dataLancamento()).isEqualTo(LocalDate.now());
        assertThat( filmeResponse.duracao()).isEqualTo( "120 m" );
        assertThat( filmeResponse.imagem()).isEqualTo( "imagem.png" );
        assertThat( filmeResponse.categoria()).isEqualTo( Categoria.ACAO );
    }

    @Test
    @DisplayName("Deveria converter um Filme em uma entity FilmeListResponse")
    void filmeToFilmeListResponse() {
        FilmeFactory filmeFactory = new FilmeFactory();

        FilmeListResponse filmeListResponse = FilmeMapper.INSTANCE.filmeToFilmeListResponse(filmeFactory.getFilme());

        //then
        assertThat( filmeListResponse ).isNotNull();
        assertThat( filmeListResponse.id()).isEqualTo( 1L );
        assertThat( filmeListResponse.nome()).isEqualTo( "FILME 1" );
        assertThat( filmeListResponse.dataLancamento()).isEqualTo(LocalDate.now());
        assertThat( filmeListResponse.duracao()).isEqualTo( "120 m" );
        assertThat( filmeListResponse.imagem()).isEqualTo( "imagem.png" );
        assertThat( filmeListResponse.categoria()).isEqualTo( Categoria.ACAO );
    }
}