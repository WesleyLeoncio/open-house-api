package wl.open_house_api.model.filme.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wl.open_house_api.model.filme.entity.Filme;
import wl.open_house_api.model.filme.enuns.Categoria;
import wl.open_house_api.model.filme.request.FilmeRequestCreat;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FilmeMapperTest {

    @Test
    @DisplayName("Deveria converter um FilmeRequestCreat em uma entity Filme")
    void filmeRequestCreatToFilmeCenario1() {
        FilmeRequestCreat filmeRequestCreat = new FilmeRequestCreat(
                "FILME 1", "DESCRICAO", LocalDate.now(), "120 m",
                "imagem.png", Categoria.ACAO
        );

        Filme filme = FilmeMapper.INSTANCE.filmeRequestCreatToFilme(filmeRequestCreat);

        //then
        assertThat( filme ).isNotNull();
        assertThat( filme.getNome()).isEqualTo( "FILME 1" );
        assertThat( filme.getDescricao()).isEqualTo( "DESCRICAO" );
        assertThat( filme.getDataLancamento()).isEqualTo(LocalDate.now());
        assertThat( filme.getDuracao()).isEqualTo( "120 m" );
        assertThat( filme.getImagem()).isEqualTo( "imagem.png" );
        assertThat( filme.getCategoria()).isEqualTo( Categoria.ACAO );
    }
}