package wl.open_house_api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import wl.open_house_api.model.filme.request.FilmeRequest;
import wl.open_house_api.model.filme.response.FilmeListResponse;
import wl.open_house_api.model.filme.response.FilmeResponse;

public interface FilmeServiceCrud {
    public FilmeResponse insert(FilmeRequest filmeRequest);

    public FilmeResponse update(FilmeRequest filmeRequest);

    public Page<FilmeListResponse> findMovies(Pageable pageable);

    public FilmeResponse findMovie(Long id);

    public void deleteMovie(Long id);

}
