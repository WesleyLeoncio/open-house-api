package wl.open_house_api.model.avaliacao.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import wl.open_house_api.model.avaliacao.entity.AvaliacaoDeFilmes;
import wl.open_house_api.model.avaliacao.request.AvaliarFilmeRequest;
import wl.open_house_api.model.avaliacao.response.AvaliacaoDeFilmesResponse;

@Mapper
public interface AvaliacaoMapper {

    AvaliacaoMapper INSTANCE = Mappers.getMapper( AvaliacaoMapper.class );

    AvaliacaoDeFilmesResponse avaliacaoFilmeToAavaliacaoFilmeResponse(AvaliacaoDeFilmes avaliacaoDeFilmes);

}
