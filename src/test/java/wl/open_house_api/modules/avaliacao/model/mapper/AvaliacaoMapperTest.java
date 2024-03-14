package wl.open_house_api.modules.avaliacao.model.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wl.open_house_api.modules.avaliacao.factory.AvaliacaoFilmeFactory;
import wl.open_house_api.modules.avaliacao.model.response.AvaliacaoDeFilmesResponse;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


class AvaliacaoMapperTest {

    @Test
    @DisplayName("Deveria converter um AvaliacaoFilme em uma entity AvaliacaoFilmeResponse")
    void avaliacaoFilmeToAavaliacaoFilmeResponse() {
        AvaliacaoFilmeFactory avaliacaoFilmeFactory = new AvaliacaoFilmeFactory();

        AvaliacaoDeFilmesResponse avaliacaoDeFilmesResponse =
                AvaliacaoMapper.INSTANCE.avaliacaoFilmeToAvaliacaoFilmeResponse(avaliacaoFilmeFactory.getAvaliacaoFilmes());

        assertThat(avaliacaoDeFilmesResponse).isNotNull();
//
        assertThat(avaliacaoDeFilmesResponse.filme().id()).isEqualTo(UUID.fromString("09b231da-8189-45ba-936c-65c32beaecb1"));
        assertThat(avaliacaoDeFilmesResponse.nota()).isEqualTo(5);

    }

}