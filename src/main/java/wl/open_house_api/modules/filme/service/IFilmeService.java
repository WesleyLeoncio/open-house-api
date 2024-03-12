package wl.open_house_api.modules.filme.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import wl.open_house_api.modules.filme.model.entity.Filme;
import wl.open_house_api.modules.filme.model.request.FilmeRequestCreat;
import wl.open_house_api.modules.filme.model.request.FilmeRequestEdit;
import wl.open_house_api.modules.filme.model.response.FilmeResponse;

import java.util.UUID;


public interface IFilmeService {
    FilmeResponse insert(FilmeRequestCreat filmeRequestCreat);

    FilmeResponse update(UUID id, FilmeRequestEdit filmeRequestEdit);

    Page<FilmeResponse> findMovies(Pageable pageable);

    FilmeResponse findMovie(UUID id);

    void deleteMovie(UUID id);

    Filme verfificarFilme(UUID id);


}
