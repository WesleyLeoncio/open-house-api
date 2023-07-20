package wl.open_house_api.model.usuario.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wl.open_house_api.model.profile.request.ProfileRequest;
import wl.open_house_api.model.profile.request.ProfileRequestRole;
import wl.open_house_api.model.usuario.entity.Usuario;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatMaster;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatUser;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UsuarioMapperTest {

    @Test
    @DisplayName("Deveria converter um usuarioResquestCreatUserToUsuario em uma entity Usuario")
    void usuarioResquestCreatUserToUsuario() {
        ProfileRequestRole role1 = new ProfileRequestRole(1L);
        List<ProfileRequestRole> roles = new ArrayList<>();
        roles.add(role1);

        UsuarioRequestCreatUser user = new UsuarioRequestCreatUser(
                "Wesley", "admin@email.com", "123456"
        );

        Usuario usuario =  UsuarioMapper.INSTANCE.usuarioResquestCreatUserToUsuario(user);
        assertThat( usuario ).isNotNull();
        assertThat( usuario.getNome()).isEqualTo( "Wesley" );
        assertThat( usuario.getLogin()).isEqualTo( "admin@email.com" );
        assertThat( usuario.getSenha()).isEqualTo( "123456" );
    }

}


