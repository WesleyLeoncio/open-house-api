package wl.open_house_api.modules.filme.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import wl.open_house_api.modules.filme.model.request.FilmeRequestEdit;
import wl.open_house_api.modules.filme.model.entity.Filme;
import wl.open_house_api.modules.filme.model.request.FilmeRequestCreat;
import wl.open_house_api.modules.filme.model.response.FilmeResponse;
import wl.open_house_api.modules.filme.model.response.FilmeResponseCategoriaFilme;
import wl.open_house_api.modules.filme.model.response.FilmeResponseCreat;
import wl.open_house_api.modules.filme.model.response.FilmeResponseUpdate;

@Mapper
public interface FilmeMapper {

    FilmeMapper INSTANCE = Mappers.getMapper( FilmeMapper.class );

    Filme filmeRequestCreatToFilme(FilmeRequestCreat filmeRequestCreat);

    Filme filmeRequestEditToFilme(FilmeRequestEdit filmeRequestEdit);

    FilmeResponse filmeToFilmeResponse(Filme filme);

    FilmeResponseCreat filmeToFilmeResponseCreat(Filme filme);

    FilmeResponseUpdate filmeToFilmeResponseUpdate(Filme filme);

    FilmeResponseCategoriaFilme filmeToFilmeResponseCategoriaFilme(Filme filme);

}
