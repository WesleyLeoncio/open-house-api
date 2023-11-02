package wl.open_house_api.model.categoria.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import wl.open_house_api.model.categoria.entiy.Categoria;
import wl.open_house_api.model.categoria.request.CategoriaRequest;
import wl.open_house_api.model.categoria.request.CategoriaRequestCreat;
import wl.open_house_api.model.categoria.response.CategoriaResponse;
import wl.open_house_api.model.categoria.response.CategoriaResponseId;

@Mapper
public interface CategoriaMapper {
    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    Categoria categoriaRequestCreatToCategoria(CategoriaRequestCreat categoriaRequestCreat);

    Categoria categoriaRequestToCategoria(CategoriaRequest categoriaRequest);

    CategoriaResponse categoriaToCategoriaResponse(Categoria categoria);

    CategoriaResponseId categoriaToCategoriaResponseId(Categoria categoria);
}
