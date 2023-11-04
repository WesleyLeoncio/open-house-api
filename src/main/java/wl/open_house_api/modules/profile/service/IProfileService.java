package wl.open_house_api.modules.profile.service;

import wl.open_house_api.modules.profile.model.request.ProfileRequest;
import wl.open_house_api.modules.profile.model.request.ProfileRequestUser;
import wl.open_house_api.modules.profile.model.response.ProfileResponse;

public interface IProfileService {

    ProfileResponse adicionarProfile(ProfileRequest profileRequest);

    ProfileResponse adicionarProfileUser(ProfileRequestUser profileRequestUser);

    void removerProfile(ProfileRequest profileRequest);
}
