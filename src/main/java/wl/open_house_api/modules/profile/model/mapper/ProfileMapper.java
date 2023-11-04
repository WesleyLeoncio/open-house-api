package wl.open_house_api.modules.profile.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import wl.open_house_api.modules.profile.model.entity.Profile;
import wl.open_house_api.modules.profile.model.response.ProfileResponse;


@Mapper
public interface ProfileMapper {

    ProfileMapper INSTANCE = Mappers.getMapper( ProfileMapper.class );

    ProfileResponse profileToProfileResponse(Profile profile);
}
