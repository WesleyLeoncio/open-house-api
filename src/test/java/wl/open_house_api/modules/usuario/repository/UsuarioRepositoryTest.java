package wl.open_house_api.modules.usuario.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import wl.open_house_api.modules.usuario.factory.UsuarioFactory;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository usuarioRepository;

    private UsuarioFactory usuarioFactory;

    @BeforeEach
    public void beforeEach(){
        this.usuarioFactory = new UsuarioFactory();
    }

    @Test
    @DisplayName("Deveria retornar o status do usuario")
    void findStatusById() {
        cadastroUser();

        boolean statusUser = usuarioRepository.findStatusById(this.usuarioFactory.getUsuario().getId());

        assertThat(statusUser).isTrue();
    }

    public void cadastroUser(){

        usuarioRepository.save(this.usuarioFactory.getUsuario());
    }
}