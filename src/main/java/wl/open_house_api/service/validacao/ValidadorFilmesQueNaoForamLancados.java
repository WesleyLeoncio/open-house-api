package wl.open_house_api.service.validacao;

import org.springframework.stereotype.Service;
import wl.open_house_api.infra.exeptions.ValidacaoException;
import wl.open_house_api.model.avaliacao.request.AvaliarFilmeRequest;
import wl.open_house_api.model.filme.response.FilmeResponse;
import wl.open_house_api.service.FilmeService;
import wl.open_house_api.service.interfaces.ValidadorAvaliacaoDeFilme;

import java.time.LocalDate;

@Service
public class ValidadorFilmesQueNaoForamLancados implements ValidadorAvaliacaoDeFilme {

    final FilmeService service;

    public ValidadorFilmesQueNaoForamLancados(FilmeService service) {
        this.service = service;
    }

    @Override
    public void validar(AvaliarFilmeRequest avaliar) {
        LocalDate hoje = LocalDate.now();
        FilmeResponse filme = service.findMovie(avaliar.idFilme());
        boolean verificarData = hoje.isBefore(filme.dataLancamento());
        if (verificarData){
            throw new ValidacaoException("Filmes que não foram lançados não podem receber avaliações.");
        }
    }
}
