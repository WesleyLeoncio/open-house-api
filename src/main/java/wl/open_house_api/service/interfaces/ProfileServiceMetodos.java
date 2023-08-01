package wl.open_house_api.service.interfaces;

import wl.open_house_api.model.profile.request.ProfileRequest;
import wl.open_house_api.model.profile.request.ProfileRequestUser;
import wl.open_house_api.model.profile.response.ProfileResponse;

public interface ProfileServiceMetodos {

    public ProfileResponse adicionarProfile(ProfileRequest profileRequest);

    public ProfileResponse adicionarProfileUser(ProfileRequestUser profileRequestUser);

    public void removerProfile(ProfileRequest profileRequest);
}
