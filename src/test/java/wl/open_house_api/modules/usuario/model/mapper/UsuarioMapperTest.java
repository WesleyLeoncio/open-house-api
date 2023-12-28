package wl.open_house_api.modules.usuario.model.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wl.open_house_api.modules.usuario.factory.UsuarioFactory;
import wl.open_house_api.modules.usuario.model.entity.Usuario;
import wl.open_house_api.modules.usuario.model.response.UsuarioResponse;

import static org.assertj.core.api.Assertions.assertThat;


class UsuarioMapperTest {
    private UsuarioFactory usuarioFactory;

    @BeforeEach
    public void beforeEach(){
        this.usuarioFactory = new UsuarioFactory();
    }

    @Test
    @DisplayName("Deveria converter um UsuarioResquestCreatUser em uma entity Usuario")
    void usuarioResquestCreatUserToUsuario() {
        Usuario usuario = UsuarioMapper.INSTANCE.usuarioResquestCreatUserToUsuario(usuarioFactory.getUsuarioRequestCreatUser());

        assertThat(usuario).isNotNull();
        assertThat(usuario.getNome()).isEqualTo("Usuario");
        assertThat(usuario.getLogin()).isEqualTo("usuario@email.com");
        assertThat(usuario.getSenha()).isEqualTo("123456");
    }

    @Test
    @DisplayName("Deveria converter um UsuarioResquestCreatMaster em uma entity Usuario")
    void usuarioResquestCreatMasterToUsuario() {
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
        UsuarioResponse usuarioResponseCrud =
                UsuarioMapper.INSTANCE.usuarioToUsuarioResponse(usuarioFactory.getUsuario());

        assertThat(usuarioResponseCrud.nome()).isEqualTo("Usuario");
        assertThat(usuarioResponseCrud.login()).isEqualTo("usuario@email.com");
        assertThat(usuarioResponseCrud.status()).isTrue();

    }

    @Test
    @DisplayName("Deveria converter um usuario em uma entity UsuarioResponse")
    void usuarioToUsuarioResponse() {

        UsuarioResponse usuarioResponse =
                UsuarioMapper.INSTANCE.usuarioToUsuarioResponse(usuarioFactory.getUsuarioRoles());

        assertThat(usuarioResponse.nome()).isEqualTo("Usuario");
        assertThat(usuarioResponse.login()).isEqualTo("usuario@email.com");
        assertThat(usuarioResponse.status()).isTrue();
        assertThat(usuarioResponse.role().get(0).nome()).isEqualTo("ROLE_USER");
    }
}