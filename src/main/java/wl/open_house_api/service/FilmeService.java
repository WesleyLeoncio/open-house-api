package wl.open_house_api.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wl.open_house_api.model.filme.entity.Filme;
import wl.open_house_api.model.filme.mapper.FilmeMapper;
import wl.open_house_api.model.filme.request.FilmeRequestCreat;
import wl.open_house_api.model.filme.request.FilmeRequestEdit;
import wl.open_house_api.model.filme.response.FilmeListResponse;
import wl.open_house_api.model.filme.response.FilmeResponse;
import wl.open_house_api.repository.FilmeRepository;
import wl.open_house_api.service.interfaces.FilmeServiceCrud;

import java.util.Optional;

@Service
public class FilmeService implements FilmeServiceCrud {

    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public FilmeResponse insert(FilmeRequestCreat filmeRequestCreat) {
        Filme filme = repository.save(FilmeMapper.INSTANCE.filmeRequestCreatToFilme(filmeRequestCreat));
        return FilmeMapper.INSTANCE.filmeToFilmeResponse(filme);
    }

    @Override
    public FilmeResponse update(FilmeRequestEdit filmeRequestEdit) {
        verfificarFilme(filmeRequestEdit.id());
        Filme filme = repository.save(FilmeMapper.INSTANCE.filmeRequestEditToFilme(filmeRequestEdit));
        return FilmeMapper.INSTANCE.filmeToFilmeResponse(filme);
    }


    @Override
    public Page<FilmeListResponse> findMovies(Pageable pageable) {
        return repository.findAll(pageable).map(filme -> FilmeMapper.INSTANCE.filmeToFilmeListResponse(filme));
    }

    @Override
    @Transactional
    public FilmeResponse findMovie(Long id) {
        Filme filme = repository.getReferenceById(id);
        return FilmeMapper.INSTANCE.filmeToFilmeResponse(filme);
    }

    @Override
    @Transactional
    public void deleteMovie(Long id) {
        repository.delete(verfificarFilme(id));
    }

    public Filme verfificarFilme(Long id){
        Optional<Filme> filme = repository.findById(id);
        if(!filme.isPresent()){
            throw new EntityNotFoundException();
        }
        return filme.get();
    }


}
