package wl.open_house_api.modules.filme.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import wl.open_house_api.modules.filme.model.request.FilmeRequestEdit;
import wl.open_house_api.modules.filme.model.entity.Filme;
import wl.open_house_api.modules.filme.model.request.FilmeRequestCreat;
import wl.open_house_api.modules.filme.model.response.FilmeResponse;

@Mapper
public interface FilmeMapper {

    FilmeMapper INSTANCE = Mappers.getMapper( FilmeMapper.class );

    Filme filmeRequestCreatToFilme(FilmeRequestCreat filmeRequestCreat);

    Filme filmeRequestEditToFilme(FilmeRequestEdit filmeRequestEdit);

    FilmeResponse filmeToFilmeResponse(Filme filme);

}
