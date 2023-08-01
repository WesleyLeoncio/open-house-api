package wl.open_house_api.model.profile.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import wl.open_house_api.model.profile.entity.Profile;
import wl.open_house_api.model.profile.response.ProfileResponse;


@Mapper
public interface ProfileMapper {

    ProfileMapper INSTANCE = Mappers.getMapper( ProfileMapper.class );

    ProfileResponse profileToProfileResponse(Profile profile);
}
