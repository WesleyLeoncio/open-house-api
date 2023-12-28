package wl.open_house_api.modules.categoria.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wl.open_house_api.infra.exeptions.ValidacaoException;
import wl.open_house_api.modules.categoria.model.entiy.Categoria;
import wl.open_house_api.modules.categoria.model.mapper.CategoriaMapper;
import wl.open_house_api.modules.categoria.model.request.CategoriaRequest;
import wl.open_house_api.modules.categoria.model.request.CategoriaRequestCreat;
import wl.open_house_api.modules.categoria.model.response.CategoriaResponse;
import wl.open_house_api.modules.categoria.repository.CategoriaRepository;

import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public CategoriaResponse insert(CategoriaRequestCreat categoriaRequestCreat) {
        Categoria categoria = repository.save(CategoriaMapper.INSTANCE.categoriaRequestCreatToCategoria(categoriaRequestCreat));
        return CategoriaMapper.INSTANCE.categoriaToCategoriaResponse(categoria);
    }

    @Override
    public CategoriaResponse update(CategoriaRequest categoriaRequest) {
        verificarCategoria(categoriaRequest.id());
        Categoria categoria = repository.save(CategoriaMapper.INSTANCE.categoriaRequestToCategoria(categoriaRequest));
        return CategoriaMapper.INSTANCE.categoriaToCategoriaResponse(categoria);
    }

    @Override
    public CategoriaResponse findCategoria(Long id) {
        Categoria categoria = verificarCategoria(id);
        return CategoriaMapper.INSTANCE.categoriaToCategoriaResponse(categoria);
    }

    @Override
    public Page<CategoriaResponse> findCategorias(Pageable pageable) {
        return repository.findAll(pageable).map(CategoriaMapper.INSTANCE::categoriaToCategoriaResponse);
    }

    @Override
    public void deleteCategoria(Long id) {
        repository.delete(verificarCategoria(id));
    }

    @Override
    public Categoria verificarCategoria(Long id) {
        Optional<Categoria> categoria = repository.findById(id);
        if (categoria.isEmpty()) {
            throw new ValidacaoException("A Categoria não existe, verifique e tente novamente!");
        }
        return categoria.get();
    }
}
