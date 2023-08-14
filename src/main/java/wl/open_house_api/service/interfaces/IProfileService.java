package wl.open_house_api.service.interfaces;

import wl.open_house_api.model.profile.request.ProfileRequest;
import wl.open_house_api.model.profile.request.ProfileRequestUser;
import wl.open_house_api.model.profile.response.ProfileResponse;

public interface IProfileService {

    ProfileResponse adicionarProfile(ProfileRequest profileRequest);

    ProfileResponse adicionarProfileUser(ProfileRequestUser profileRequestUser);

    void removerProfile(ProfileRequest profileRequest);
}
