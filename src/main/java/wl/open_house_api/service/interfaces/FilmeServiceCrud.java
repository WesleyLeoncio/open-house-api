package wl.open_house_api.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import wl.open_house_api.model.filme.request.FilmeRequestCreat;
import wl.open_house_api.model.filme.request.FilmeRequestEdit;
import wl.open_house_api.model.filme.response.FilmeListResponse;
import wl.open_house_api.model.filme.response.FilmeResponse;

public interface FilmeServiceCrud {
    FilmeResponse insert(FilmeRequestCreat filmeRequestCreat);

    FilmeResponse update(FilmeRequestEdit filmeRequestEdit);

    Page<FilmeListResponse> findMovies(Pageable pageable);

    FilmeResponse findMovie(Long id);

    void deleteMovie(Long id);

}
