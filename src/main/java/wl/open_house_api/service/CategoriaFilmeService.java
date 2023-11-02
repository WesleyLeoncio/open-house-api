package wl.open_house_api.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import wl.open_house_api.model.categoria.entiy.Categoria;
import wl.open_house_api.model.categoria_filme.entity.CategoriaFilme;
import wl.open_house_api.model.categoria_filme.entity.CategoriaFilmeId;
import wl.open_house_api.model.categoria_filme.mapper.CategoriaFilmeMapper;
import wl.open_house_api.model.categoria_filme.request.CategoriaFilmeRequest;
import wl.open_house_api.model.categoria_filme.response.CategoriaFilmeResponse;
import wl.open_house_api.model.filme.entity.Filme;
import wl.open_house_api.repository.CategoriaFilmeRepository;
import wl.open_house_api.repository.FilmeRepository;
import wl.open_house_api.service.interfaces.ICategoriaFilmeService;
import wl.open_house_api.service.interfaces.ICategoriaService;


import java.util.Optional;

@Service
public class CategoriaFilmeService implements ICategoriaFilmeService {

    private ICategoriaService categoriaService;

    private FilmeRepository filmeRepository;

    private CategoriaFilmeRepository repository;

    public CategoriaFilmeService(ICategoriaService categoriaService, FilmeRepository filmeRepository, CategoriaFilmeRepository repository) {
        this.categoriaService = categoriaService;
        this.filmeRepository = filmeRepository;
        this.repository = repository;
    }


    @Override
    public CategoriaFilmeResponse adicionarCategoriaFilme(CategoriaFilmeRequest categoriaFilmeRequest) {
        CategoriaFilme categoriaFilme = categoriaFilmeFactory(categoriaFilmeRequest);

        return CategoriaFilmeMapper.INSTANCE.
                categoriaFilmeToCategoriaFilmeResponse(repository.save(categoriaFilme));
    }

    @Override
    public void removerCategoriaFilme(CategoriaFilmeRequest categoriaFilmeRequest) {
        repository.delete(categoriaFilmeFactory(categoriaFilmeRequest));
    }

    private CategoriaFilme categoriaFilmeFactory(CategoriaFilmeRequest categoriaFilmeRequest){
        Categoria categoria = categoriaService.verificarCategoria(categoriaFilmeRequest.categoriaId());
        Filme filme = verfificarFilme(categoriaFilmeRequest.filmeId());
        CategoriaFilmeId categoriaFilmeId = new CategoriaFilmeId(filme.getId(), categoria.getId());
        return new CategoriaFilme(categoriaFilmeId, filme, categoria);
    }

    private Filme verfificarFilme(Long id) {
        Optional<Filme> filme = filmeRepository.findById(id);
        if (filme.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return filme.get();
    }
}
