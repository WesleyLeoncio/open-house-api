package wl.open_house_api.validation.validacao;

import org.springframework.stereotype.Service;
import wl.open_house_api.infra.exeptions.ValidacaoException;
import wl.open_house_api.modules.avaliacao.model.request.AvaliarFilmeRequest;
import wl.open_house_api.modules.filme.model.response.FilmeResponse;
import wl.open_house_api.modules.filme.service.FilmeService;
import wl.open_house_api.validation.interfaces.IValidadorAvaliacaoDeFilme;

import java.time.LocalDate;

@Service
public class ValidadorFilmesQueNaoForamLancados implements IValidadorAvaliacaoDeFilme {

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
