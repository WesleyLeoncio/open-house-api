package wl.open_house_api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wl.open_house_api.model.filme.entity.Filme;
import wl.open_house_api.model.filme.request.FilmeRequestCreat;
import wl.open_house_api.model.filme.request.FilmeRequestEdit;
import wl.open_house_api.model.filme.response.FilmeListResponse;
import wl.open_house_api.model.filme.response.FilmeResponse;
import wl.open_house_api.repository.FilmeRepository;
import wl.open_house_api.service.interfaces.FilmeServiceCrud;

@Service
public class FilmeService implements FilmeServiceCrud {

    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public FilmeResponse insert(FilmeRequestCreat filmeRequestCreat) {
        Filme filme = repository.save(new Filme(filmeRequestCreat));
        return new FilmeResponse(filme);
    }

    @Override
    public FilmeResponse update(FilmeRequestEdit filmeRequestEdit) {
        Filme filme = repository.save(new Filme(filmeRequestEdit));
        return new FilmeResponse(filme);
    }


    @Override
    public Page<FilmeListResponse> findMovies(Pageable pageable) {
        return repository.findAll(pageable).map(FilmeListResponse::new);
    }

    @Override
    @Transactional
    public FilmeResponse findMovie(Long id) {
        Filme filme = repository.getReferenceById(id);
        return new FilmeResponse(filme);
    }

    @Override
    @Transactional
    public FilmeResponse deleteMovie(Long id) {
        Filme filme = repository.getReferenceById(id);
        repository.delete(filme);
        return new FilmeResponse(filme);
    }


}
