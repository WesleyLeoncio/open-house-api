package wl.open_house_api.model.usuario.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wl.open_house_api.model.usuario.entity.Usuario;
import wl.open_house_api.model.usuario.factory.UsuarioFactory;
import wl.open_house_api.model.usuario.response.UsuarioResponse;
import wl.open_house_api.model.usuario.response.UsuarioResponseCrud;

import static org.assertj.core.api.Assertions.assertThat;

class UsuarioMapperTest {

    @Test
    @DisplayName("Deveria converter um UsuarioResquestCreatUser em uma entity Usuario")
    void usuarioResquestCreatUserToUsuario() {
        UsuarioFactory usuarioFactory = new UsuarioFactory();

        Usuario usuario = UsuarioMapper.INSTANCE.usuarioResquestCreatUserToUsuario(usuarioFactory.getUsuarioRequestCreatUser());
        assertThat(usuario).isNotNull();
        assertThat(usuario.getNome()).isEqualTo("Usuario");
        assertThat(usuario.getLogin()).isEqualTo("usuario@email.com");
        assertThat(usuario.getSenha()).isEqualTo("123456");
    }

    @Test
    @DisplayName("Deveria converter um UsuarioResquestCreatMaster em uma entity Usuario")
    void usuarioResquestCreatMasterToUsuario() {
        UsuarioFactory usuarioFactory = new UsuarioFactory();

        Usuario usuario = UsuarioMapper.INSTANCE.usuarioResquestCreatMasterToUsuario(usuarioFactory.getUsuarioRequestCreatMaster());
        assertThat(usuario).isNotNull();
        assertThat(usuario.getNome()).isEqualTo("Usuario");
        assertThat(usuario.getLogin()).isEqualTo("usuario@email.com");
        assertThat(usuario.getSenha()).isEqualTo("123456");
        assertThat(usuario.getStatus()).isTrue();
    }

    @Test
    @DisplayName("Deveria converter um usuario em uma entity UsuarioResponseCrud")
    void usuarioToUsuarioResponseCrud() {
        UsuarioFactory usuarioFactory = new UsuarioFactory();

        UsuarioResponseCrud usuarioResponseCrud =
                UsuarioMapper.INSTANCE.usuarioToUsuarioResponseCrud(usuarioFactory.getUsuario());
        assertThat(usuarioResponseCrud.nome()).isEqualTo("Usuario");
        assertThat(usuarioResponseCrud.login()).isEqualTo("usuario@email.com");
        assertThat(usuarioResponseCrud.status()).isTrue();

    }

    @Test
    @DisplayName("Deveria converter um usuario em uma entity UsuarioResponse")
    void usuarioToUsuarioResponse() {
        UsuarioFactory usuarioFactory = new UsuarioFactory();

        UsuarioResponse usuarioResponse =
                UsuarioMapper.INSTANCE.usuarioToUsuarioResponse(usuarioFactory.getUsuario());
        assertThat(usuarioResponse.nome()).isEqualTo("Usuario");
        assertThat(usuarioResponse.login()).isEqualTo("usuario@email.com");
        assertThat(usuarioResponse.status()).isTrue();
        assertThat(usuarioResponse.role().get(0).nome()).isEqualTo("ROLE_USER");
    }
}


