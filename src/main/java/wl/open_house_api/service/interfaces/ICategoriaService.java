package wl.open_house_api.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import wl.open_house_api.model.categoria.entiy.Categoria;
import wl.open_house_api.model.categoria.request.CategoriaRequest;
import wl.open_house_api.model.categoria.request.CategoriaRequestCreat;
import wl.open_house_api.model.categoria.response.CategoriaResponse;
import wl.open_house_api.model.categoria.response.CategoriaResponseId;

public interface ICategoriaService {

    CategoriaResponseId insert(CategoriaRequestCreat categoriaRequestCreat);

    CategoriaResponseId update(CategoriaRequest categoriaRequest);

    CategoriaResponseId findCategoria(Long id);

    Page<CategoriaResponseId> findCategorias(Pageable pageable);

    void deleteCategoria(Long id);

    Categoria verificarCategoria(Long id);
}
