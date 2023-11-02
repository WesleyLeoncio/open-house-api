package wl.open_house_api.model.categoria_filme.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import wl.open_house_api.model.categoria_filme.entity.CategoriaFilme;
import wl.open_house_api.model.categoria_filme.response.CategoriaFilmeResponse;

@Mapper
public interface CategoriaFilmeMapper {

    CategoriaFilmeMapper INSTANCE = Mappers.getMapper( CategoriaFilmeMapper.class );

    CategoriaFilmeResponse categoriaFilmeToCategoriaFilmeResponse(CategoriaFilme categoriaFilme);
}
