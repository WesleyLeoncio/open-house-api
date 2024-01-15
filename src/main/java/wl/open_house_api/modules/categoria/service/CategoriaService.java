package wl.open_house_api.modules.categoria.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wl.open_house_api.infra.exeptions.ObjectNotFoundExeption;
import wl.open_house_api.modules.categoria.model.entiy.Categoria;
import wl.open_house_api.modules.categoria.model.mapper.CategoriaMapper;
import wl.open_house_api.modules.categoria.model.request.CategoriaRequest;
import wl.open_house_api.modules.categoria.model.response.CategoriaResponse;
import wl.open_house_api.modules.categoria.repository.CategoriaRepository;


@Service
public class CategoriaService implements ICategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public CategoriaResponse insert(CategoriaRequest categoriaRequest) {
        Categoria categoria = repository.save(CategoriaMapper.INSTANCE.categoriaRequestToCategoria(categoriaRequest));
        return CategoriaMapper.INSTANCE.categoriaToCategoriaResponse(categoria);
    }

    @Override
    @Transactional
    public CategoriaResponse update(Long id,CategoriaRequest categoriaRequest) {
        verificarCategoria(id);
        Categoria categoria = CategoriaMapper.INSTANCE.categoriaRequestToCategoria(categoriaRequest);
        categoria.setId(id);
        return CategoriaMapper.INSTANCE.categoriaToCategoriaResponse(repository.save(categoria));
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
        return repository.findById(id).orElseThrow(ObjectNotFoundExeption::new);
    }

}
