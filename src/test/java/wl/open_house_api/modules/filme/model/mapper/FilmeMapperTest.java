package wl.open_house_api.modules.filme.model.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wl.open_house_api.modules.filme.factory.FilmeFactory;
import wl.open_house_api.modules.filme.model.entity.Filme;
import wl.open_house_api.modules.filme.model.response.FilmeResponse;

import java.time.LocalDate;
import java.util.UUID;

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
        assertThat( filmeResponse.id()).isEqualTo(UUID.fromString("09b231da-8189-45ba-936c-65c32beaecb1") );
        assertThat( filmeResponse.nome()).isEqualTo( "FILME 1" );
        assertThat( filmeResponse.descricao()).isEqualTo( "DESCRICAO" );
        assertThat( filmeResponse.dataLancamento()).isEqualTo(LocalDate.now());
        assertThat( filmeResponse.duracao()).isEqualTo( "120 m" );
        assertThat( filmeResponse.imagem()).isEqualTo( "imagem.png" );
    }


}