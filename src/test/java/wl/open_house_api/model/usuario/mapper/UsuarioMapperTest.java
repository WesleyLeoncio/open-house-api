package wl.open_house_api.model.usuario.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wl.open_house_api.model.profile.entity.Profile;
import wl.open_house_api.model.usuario.entity.Usuario;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatMaster;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioMapperTest {

    @Test
    @DisplayName("Deveria converter um UsuarioRequestCreatMaster em uma entity Usuario")
    void usuarioResquestCreatMasterToUsuarioCenario1() {

        Profile profileEsperado = new Profile(1l, "ROLE_MASTER");

        UsuarioRequestCreatMaster master = new UsuarioRequestCreatMaster(
              "Wesley", "admin@email.com", "123456",profileEsperado
        );


        Usuario usuario =  UsuarioMapper.INSTANCE.usuarioResquestCreatMasterToUsuario(master);

        assertThat( usuario ).isNotNull();
        assertThat( usuario.getNome()).isEqualTo( "Wesley" );
        assertThat( usuario.getLogin()).isEqualTo( "admin@email.com" );
        assertThat( usuario.getSenha()).isEqualTo( "123456" );
        assertThat( usuario.getProfile()).isEqualTo( profileEsperado );
    }
}