package wl.open_house_api.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import wl.open_house_api.model.filme.entity.Filme;
import wl.open_house_api.model.filme.request.FilmeRequestCreat;
import wl.open_house_api.model.filme.request.FilmeRequestEdit;
import wl.open_house_api.model.filme.response.FilmeResponse;
import wl.open_house_api.model.filme.response.FilmeResponseCreat;
import wl.open_house_api.model.filme.response.FilmeResponseUpdate;

public interface IFilmeService {
    FilmeResponseCreat insert(FilmeRequestCreat filmeRequestCreat);

    FilmeResponseUpdate update(FilmeRequestEdit filmeRequestEdit);

    Page<FilmeResponse> findMovies(Pageable pageable);

    FilmeResponse findMovie(Long id);

    void deleteMovie(Long id);

    Filme verfificarFilme(Long id);


}
