package wl.open_house_api.modules.categoria_filme.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import wl.open_house_api.modules.categoria.model.entiy.Categoria;
import wl.open_house_api.modules.categoria_filme.model.entity.CategoriaFilme;
import wl.open_house_api.modules.categoria_filme.model.entity.CategoriaFilmeId;
import wl.open_house_api.modules.categoria_filme.model.mapper.CategoriaFilmeMapper;
import wl.open_house_api.modules.categoria_filme.model.request.CategoriaFilmeRequest;
import wl.open_house_api.modules.categoria_filme.model.response.CategoriaFilmeResponse;
import wl.open_house_api.modules.filme.model.entity.Filme;
import wl.open_house_api.modules.categoria_filme.repository.CategoriaFilmeRepository;
import wl.open_house_api.modules.filme.repository.FilmeRepository;
import wl.open_house_api.modules.categoria.service.ICategoriaService;


import java.util.Optional;

@Service
public class CategoriaFilmeService implements ICategoriaFilmeService {

    private final ICategoriaService categoriaService;

    private final FilmeRepository filmeRepository;

    private final CategoriaFilmeRepository repository;

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
