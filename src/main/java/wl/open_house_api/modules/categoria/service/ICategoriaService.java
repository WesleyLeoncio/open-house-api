package wl.open_house_api.modules.categoria.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import wl.open_house_api.modules.categoria.model.entiy.Categoria;
import wl.open_house_api.modules.categoria.model.request.CategoriaRequest;
import wl.open_house_api.modules.categoria.model.request.CategoriaRequestCreat;
import wl.open_house_api.modules.categoria.model.response.CategoriaResponseId;

public interface ICategoriaService {

    CategoriaResponseId insert(CategoriaRequestCreat categoriaRequestCreat);

    CategoriaResponseId update(CategoriaRequest categoriaRequest);

    CategoriaResponseId findCategoria(Long id);

    Page<CategoriaResponseId> findCategorias(Pageable pageable);

    void deleteCategoria(Long id);

    Categoria verificarCategoria(Long id);
}
