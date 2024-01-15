package wl.open_house_api.modules.filme.service;

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


@Service
public class FilmeService implements IFilmeService {

    private final FilmeRepository repository;


    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public FilmeResponse insert(FilmeRequestCreat filmeRequest) {
        Filme filme = repository.save(FilmeMapper.INSTANCE.filmeRequestCreatToFilme(filmeRequest));
        return FilmeMapper.INSTANCE.filmeToFilmeResponse(filme);
    }

    @Override
    @Transactional
    public FilmeResponse update(Long id, FilmeRequestEdit filmeRequestEdit) {
        verfificarFilme(id);
        Filme filme = FilmeMapper.INSTANCE.filmeRequestEditToFilme(filmeRequestEdit);
        filme.setId(id);
        return FilmeMapper.INSTANCE.filmeToFilmeResponse(repository.save(filme));
    }


    @Override
    public Page<FilmeResponse> findMovies(Pageable pageable) {
        return repository.findAll(pageable).map(FilmeMapper.INSTANCE::filmeToFilmeResponse);
    }

    @Override
    @Transactional
    public FilmeResponse findMovie(Long id) {
        return FilmeMapper.INSTANCE.filmeToFilmeResponse(verfificarFilme(id));
    }

    @Override
    @Transactional
    public void deleteMovie(Long id) {
        repository.delete(verfificarFilme(id));
    }


    public Filme verfificarFilme(Long id) {
        return repository.findById(id).orElseThrow(ObjectNotFoundExeption::new);
    }


}