package wl.open_house_api.model.profile.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import wl.open_house_api.model.profile.entity.Profile;
import wl.open_house_api.model.profile.request.ProfileRequestCreat;


@Mapper
public interface ProfileMapper {
    ProfileMapper INSTANCE = Mappers.getMapper( ProfileMapper.class );

    Profile profileRequestCreatToProfile(ProfileRequestCreat profileRequestCreat);


}
