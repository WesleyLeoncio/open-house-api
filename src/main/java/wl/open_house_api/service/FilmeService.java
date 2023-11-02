package wl.open_house_api.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wl.open_house_api.model.categoria_filme.request.CategoriaFilmeRequest;
import wl.open_house_api.model.categoria_filme.request.CategoriaFilmeRequestCategoria;
import wl.open_house_api.model.filme.entity.Filme;
import wl.open_house_api.model.filme.mapper.FilmeMapper;
import wl.open_house_api.model.filme.request.FilmeRequestCreat;
import wl.open_house_api.model.filme.request.FilmeRequestEdit;
import wl.open_house_api.model.filme.response.FilmeResponse;
import wl.open_house_api.model.filme.response.FilmeResponseCreat;
import wl.open_house_api.model.filme.response.FilmeResponseUpdate;
import wl.open_house_api.repository.FilmeRepository;
import wl.open_house_api.service.interfaces.ICategoriaFilmeService;
import wl.open_house_api.service.interfaces.IFilmeService;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService implements IFilmeService {

    private final FilmeRepository repository;

    private final ICategoriaFilmeService categoriaFilmeService;

    public FilmeService(FilmeRepository repository, ICategoriaFilmeService categoriaFilmeService) {
        this.repository = repository;
        this.categoriaFilmeService = categoriaFilmeService;
    }

    @Override
    @Transactional
    public FilmeResponseCreat insert(FilmeRequestCreat filmeRequest) {
        Filme filme = repository.save(FilmeMapper.INSTANCE.filmeRequestCreatToFilme(filmeRequest));

        adicionarCategoriaFilme(filme, filmeRequest.categoriaList());

        return FilmeMapper.INSTANCE.filmeToFilmeResponseCreat(filme);
    }

    @Override
    @Transactional
    public FilmeResponseUpdate update(FilmeRequestEdit filmeRequestEdit) {
        verfificarFilme(filmeRequestEdit.id());
        Filme filme = repository.save(FilmeMapper.INSTANCE.filmeRequestEditToFilme(filmeRequestEdit));
        return FilmeMapper.INSTANCE.filmeToFilmeResponseUpdate(filme);
    }


    @Override
    public Page<FilmeResponse> findMovies(Pageable pageable) {
        return repository.findAll(pageable).map(FilmeMapper.INSTANCE::filmeToFilmeResponse);
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


    private void adicionarCategoriaFilme(Filme filme, List<CategoriaFilmeRequestCategoria> categorias) {
        categorias.forEach(c -> categoriaFilmeService.
                adicionarCategoriaFilme(new CategoriaFilmeRequest(c.categoriaId(), filme.getId())));
    }


    public Filme verfificarFilme(Long id) {
        Optional<Filme> filme = repository.findById(id);
        if (filme.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return filme.get();
    }


}
