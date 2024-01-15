package wl.open_house_api.modules.categoria.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import wl.open_house_api.modules.categoria.model.entiy.Categoria;
import wl.open_house_api.modules.categoria.model.request.CategoriaFilmeRequest;
import wl.open_house_api.modules.categoria.model.request.CategoriaRequest;
import wl.open_house_api.modules.categoria.model.response.CategoriaResponse;

import java.util.List;

@Mapper
public interface CategoriaMapper {
    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    Categoria categoriaRequestToCategoria(CategoriaRequest categoriaRequest);

    CategoriaResponse categoriaToCategoriaResponse(Categoria categoria);

    List<CategoriaFilmeRequest> categoriaToCategoriaFilmeRequest(List<Categoria> categorias);


}
