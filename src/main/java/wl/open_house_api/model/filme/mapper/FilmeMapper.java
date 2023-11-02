package wl.open_house_api.model.filme.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import wl.open_house_api.model.filme.entity.Filme;
import wl.open_house_api.model.filme.request.FilmeRequestCreat;
import wl.open_house_api.model.filme.request.FilmeRequestEdit;
import wl.open_house_api.model.filme.response.FilmeResponse;
import wl.open_house_api.model.filme.response.FilmeResponseCreat;
import wl.open_house_api.model.filme.response.FilmeResponseUpdate;

@Mapper
public interface FilmeMapper {

    FilmeMapper INSTANCE = Mappers.getMapper( FilmeMapper.class );

    Filme filmeRequestCreatToFilme(FilmeRequestCreat filmeRequestCreat);

    Filme filmeRequestEditToFilme(FilmeRequestEdit filmeRequestEdit);

    FilmeResponse filmeToFilmeResponse(Filme filme);

    FilmeResponseCreat filmeToFilmeResponseCreat(Filme filme);

    FilmeResponseUpdate filmeToFilmeResponseUpdate(Filme filme);

}
