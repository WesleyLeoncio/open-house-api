package wl.open_house_api.modules.avaliacao.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import wl.open_house_api.modules.avaliacao.model.entity.AvaliacaoDeFilmes;
import wl.open_house_api.modules.avaliacao.model.response.AvaliacaoDeFilmesResponse;

@Mapper
public interface AvaliacaoMapper {

    AvaliacaoMapper INSTANCE = Mappers.getMapper( AvaliacaoMapper.class );

    AvaliacaoDeFilmesResponse avaliacaoFilmeToAavaliacaoFilmeResponse(AvaliacaoDeFilmes avaliacaoDeFilmes);

}
