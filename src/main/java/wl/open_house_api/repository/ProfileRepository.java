package wl.open_house_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wl.open_house_api.model.profile.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
