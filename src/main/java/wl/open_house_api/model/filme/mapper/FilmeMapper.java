package wl.open_house_api.model.filme.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import org.springframework.data.domain.Page;
import wl.open_house_api.model.filme.entity.Filme;
import wl.open_house_api.model.filme.request.FilmeRequestCreat;
import wl.open_house_api.model.filme.request.FilmeRequestEdit;
import wl.open_house_api.model.filme.response.FilmeListResponse;
import wl.open_house_api.model.filme.response.FilmeResponse;

import java.util.List;

@Mapper
public interface FilmeMapper {

    FilmeMapper INSTANCE = Mappers.getMapper( FilmeMapper.class );

    Filme filmeRequestCreatToFilme(FilmeRequestCreat filmeRequestCreat);

    Filme filmeRequestEditToFilme(FilmeRequestEdit filmeRequestEdit);

    FilmeResponse filmeToFilmeResponse(Filme filme);

    FilmeListResponse filmeToFilmeListResponse(Filme filme);

}
