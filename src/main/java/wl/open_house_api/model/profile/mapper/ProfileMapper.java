package wl.open_house_api.model.profile.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import wl.open_house_api.model.profile.entity.Profile;
import wl.open_house_api.model.profile.request.ProfileRequestCreat;
import wl.open_house_api.model.profile.request.ProfileRequestEdit;
import wl.open_house_api.model.profile.response.ProfileResponse;


@Mapper
public interface ProfileMapper {
    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    Profile profileRequestCreatToProfile(ProfileRequestCreat profileRequestCreat);

    Profile profileRequestEditToProfile(ProfileRequestEdit profileRequestEdit);

    ProfileResponse profileToProfileResponse(Profile profile);


}
