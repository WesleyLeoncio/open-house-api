package wl.open_house_api.modules.profile.model.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wl.open_house_api.modules.profile.factory.ProfileFactory;
import wl.open_house_api.modules.profile.model.response.ProfileResponse;

import static org.assertj.core.api.Assertions.assertThat;


class ProfileMapperTest {
    @Test
    @DisplayName("Deveria converter um profile em uma entity ProfileResponse")
    void profileToProfileResponse() {
        ProfileFactory profileFactory = new ProfileFactory();

        ProfileResponse profileResponse = ProfileMapper.INSTANCE.profileToProfileResponse(profileFactory.getProfile());

        assertThat(profileResponse).isNotNull();
        assertThat( profileResponse.usuario().id()).isEqualTo( 1L );
        assertThat( profileResponse.role().id()).isEqualTo( 1L );
    }
}