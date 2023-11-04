package wl.open_house_api.modules.categoria.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import wl.open_house_api.modules.categoria.model.entiy.Categoria;
import wl.open_house_api.modules.categoria.model.request.CategoriaRequest;
import wl.open_house_api.modules.categoria.model.request.CategoriaRequestCreat;
import wl.open_house_api.modules.categoria.model.response.CategoriaResponse;
import wl.open_house_api.modules.categoria.model.response.CategoriaResponseId;

@Mapper
public interface CategoriaMapper {
    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    Categoria categoriaRequestCreatToCategoria(CategoriaRequestCreat categoriaRequestCreat);

    Categoria categoriaRequestToCategoria(CategoriaRequest categoriaRequest);

    CategoriaResponse categoriaToCategoriaResponse(Categoria categoria);

    CategoriaResponseId categoriaToCategoriaResponseId(Categoria categoria);
}
