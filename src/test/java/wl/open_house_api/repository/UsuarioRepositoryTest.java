package wl.open_house_api.repository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import wl.open_house_api.model.usuario.factory.UsuarioFactory;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository usuarioRepository;


    @Test
    @DisplayName("Deveria retornar o status d usuario")
    void findStatusById() {
        cadastroUser();

        boolean statusUser = usuarioRepository.findStatusById(1L);

        assertThat(statusUser).isTrue();
    }

    public void cadastroUser(){
        UsuarioFactory usuarioFactory = new UsuarioFactory();
        usuarioRepository.save(usuarioFactory.getUsuario());
    }

}