package wl.open_house_api.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import wl.open_house_api.model.profile.request.ProfileRequestCreat;
import wl.open_house_api.model.profile.request.ProfileRequestEdit;
import wl.open_house_api.model.profile.response.ProfileResponse;

public interface ProfileServiceCrud {

    public ProfileResponse insert(ProfileRequestCreat profileRequestCreat);

    public ProfileResponse update(ProfileRequestEdit profileRequestEdit);

    public ProfileResponse findProfile(Long id);

    Page<ProfileResponse> findProfiles(Pageable pageable);

    public void deleteProfile(Long id);

}
