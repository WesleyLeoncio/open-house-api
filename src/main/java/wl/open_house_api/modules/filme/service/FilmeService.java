package wl.open_house_api.modules.filme.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wl.open_house_api.infra.exeptions.ObjectNotFoundExeption;
import wl.open_house_api.modules.filme.model.entity.Filme;
import wl.open_house_api.modules.filme.model.mapper.FilmeMapper;
import wl.open_house_api.modules.filme.model.request.FilmeRequestCreat;
import wl.open_house_api.modules.filme.model.request.FilmeRequestEdit;
import wl.open_house_api.modules.filme.model.response.FilmeResponse;
import wl.open_house_api.modules.filme.repository.FilmeRepository;

import java.util.UUID;


@Service
public class FilmeService implements IFilmeService {

    private final FilmeRepository repository;


    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "filmes", allEntries = true)
    public FilmeResponse insert(FilmeRequestCreat filmeRequest) {
        Filme filme = repository.save(FilmeMapper.INSTANCE.filmeRequestCreatToFilme(filmeRequest));
        return FilmeMapper.INSTANCE.filmeToFilmeResponse(filme);
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "filmes", allEntries = true)
    public FilmeResponse update(UUID id, FilmeRequestEdit filmeRequestEdit) {
        verfificarFilme(id);
        Filme filme = FilmeMapper.INSTANCE.filmeRequestEditToFilme(filmeRequestEdit);
        filme.setId(id);
        return FilmeMapper.INSTANCE.filmeToFilmeResponse(repository.save(filme));
    }


    @Override
    @Cacheable(cacheNames = "filmes")
    public Page<FilmeResponse> findMovies(Pageable pageable) {
        return repository.findAll(pageable).map(FilmeMapper.INSTANCE::filmeToFilmeResponse);
    }

    @Override
    @Transactional
    public FilmeResponse findMovie(UUID id) {
        return FilmeMapper.INSTANCE.filmeToFilmeResponse(verfificarFilme(id));
    }

    @Override
    @Transactional
    public void deleteMovie(UUID id) {
        repository.delete(verfificarFilme(id));
    }


    public Filme verfificarFilme(UUID id) {
        return repository.findById(id).orElseThrow(ObjectNotFoundExeption::new);
    }


}