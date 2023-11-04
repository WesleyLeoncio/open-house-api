package wl.open_house_api.modules.filme.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import wl.open_house_api.modules.filme.model.entity.Filme;
import wl.open_house_api.modules.filme.model.request.FilmeRequestCreat;
import wl.open_house_api.modules.filme.model.request.FilmeRequestEdit;
import wl.open_house_api.modules.filme.model.response.FilmeResponse;
import wl.open_house_api.modules.filme.model.response.FilmeResponseCreat;
import wl.open_house_api.modules.filme.model.response.FilmeResponseUpdate;

public interface IFilmeService {
    FilmeResponseCreat insert(FilmeRequestCreat filmeRequestCreat);

    FilmeResponseUpdate update(FilmeRequestEdit filmeRequestEdit);

    Page<FilmeResponse> findMovies(Pageable pageable);

    FilmeResponse findMovie(Long id);

    void deleteMovie(Long id);

    Filme verfificarFilme(Long id);


}
