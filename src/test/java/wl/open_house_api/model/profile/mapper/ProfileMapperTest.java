package wl.open_house_api.model.profile.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wl.open_house_api.model.profile.entity.Profile;
import wl.open_house_api.model.profile.request.ProfileRequestCreat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProfileMapperTest {

    @Test
    @DisplayName("Deveria converter um ProfileRequestCreat em uma entity Profile")
    void profileRequestCreatToProfileCenario1() {
        ProfileRequestCreat profileRequestCreat = new ProfileRequestCreat("ROLE_ADMIN");

        Profile profile = ProfileMapper.INSTANCE.profileRequestCreatToProfile(profileRequestCreat);

        //then
        assertThat( profile ).isNotNull();
        assertThat( profile.getNome()).isEqualTo( "ROLE_ADMIN" );
    }
}