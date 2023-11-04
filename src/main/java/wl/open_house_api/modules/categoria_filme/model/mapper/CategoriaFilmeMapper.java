package wl.open_house_api.modules.categoria_filme.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import wl.open_house_api.modules.categoria_filme.model.entity.CategoriaFilme;
import wl.open_house_api.modules.categoria_filme.model.response.CategoriaFilmeResponse;

@Mapper
public interface CategoriaFilmeMapper {

    CategoriaFilmeMapper INSTANCE = Mappers.getMapper( CategoriaFilmeMapper.class );

    CategoriaFilmeResponse categoriaFilmeToCategoriaFilmeResponse(CategoriaFilme categoriaFilme);
}
