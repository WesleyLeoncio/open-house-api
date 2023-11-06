package wl.open_house_api.modules.avaliacao.model.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wl.open_house_api.modules.avaliacao.factory.AvaliacaoFilmeFactory;
import wl.open_house_api.modules.avaliacao.model.response.AvaliacaoDeFilmesResponse;

import static org.assertj.core.api.Assertions.assertThat;


class AvaliacaoMapperTest {

    @Test
    @DisplayName("Deveria converter um AvaliacaoFilme em uma entity AvaliacaoFilmeResponse")
    void avaliacaoFilmeToAavaliacaoFilmeResponse() {
        AvaliacaoFilmeFactory avaliacaoFilmeFactory = new AvaliacaoFilmeFactory();

        AvaliacaoDeFilmesResponse avaliacaoDeFilmesResponse =
                AvaliacaoMapper.INSTANCE.avaliacaoFilmeToAavaliacaoFilmeResponse(avaliacaoFilmeFactory.getAvaliacaoFilmes());

        assertThat(avaliacaoDeFilmesResponse).isNotNull();
        assertThat(avaliacaoDeFilmesResponse.id()).isEqualTo(1L);
        assertThat(avaliacaoDeFilmesResponse.filme().id()).isEqualTo(1L);
        assertThat(avaliacaoDeFilmesResponse.nota()).isEqualTo(5);

    }

}