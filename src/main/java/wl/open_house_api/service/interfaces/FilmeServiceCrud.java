package wl.open_house_api.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import wl.open_house_api.model.filme.request.FilmeRequestCreat;
import wl.open_house_api.model.filme.request.FilmeRequestEdit;
import wl.open_house_api.model.filme.response.FilmeListResponse;
import wl.open_house_api.model.filme.response.FilmeResponse;

public interface FilmeServiceCrud {
    public FilmeResponse insert(FilmeRequestCreat filmeRequestCreat);

    public FilmeResponse update(FilmeRequestEdit filmeRequestEdit);

    public Page<FilmeListResponse> findMovies(Pageable pageable);

    public FilmeResponse findMovie(Long id);

    public FilmeResponse deleteMovie(Long id);

}
