package wl.open_house_api.modules.categoria.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import wl.open_house_api.modules.categoria.model.entiy.Categoria;
import wl.open_house_api.modules.categoria.model.request.CategoriaRequest;
import wl.open_house_api.modules.categoria.model.response.CategoriaResponse;

import java.util.UUID;

public interface ICategoriaService {

    CategoriaResponse insert(CategoriaRequest categoriaRequest);

    CategoriaResponse update(UUID id, CategoriaRequest categoriaRequest);

    CategoriaResponse findCategoria(UUID id);

    Page<CategoriaResponse> findCategorias(Pageable pageable);

    void deleteCategoria(UUID id);

    Categoria verificarCategoria(UUID id);
}
