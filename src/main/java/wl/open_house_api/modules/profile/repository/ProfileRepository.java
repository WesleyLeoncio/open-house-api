package wl.open_house_api.modules.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wl.open_house_api.modules.profile.model.entity.Profile;
import wl.open_house_api.modules.profile.model.entity.ProfileId;

public interface ProfileRepository extends JpaRepository<Profile, ProfileId> {
}
