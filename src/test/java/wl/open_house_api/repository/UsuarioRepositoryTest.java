package wl.open_house_api.repository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import wl.open_house_api.model.profile.factory.ProfileFactory;
import wl.open_house_api.model.role.factory.RoleFactory;
import wl.open_house_api.model.usuario.factory.UsuarioFactory;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private TestEntityManager em;



    @Test
    @DisplayName("Deveria retornar o status d usuario")
    void findStatusById() {
        cadastroUser();
        cadastrarRole();
        cadastrarProfile();
        //boolean statusUser = usuarioRepository.findStatusById(1L);

        assertThat(false).isTrue();
    }

    public void cadastroUser(){
        UsuarioFactory usuarioFactory = new UsuarioFactory();
        usuarioRepository.save(usuarioFactory.getUsuario());
    }

    public void cadastrarRole(){
        RoleFactory roleFactory = new RoleFactory();
        em.persist(roleFactory.getRole());
    }

    public void cadastrarProfile(){
        ProfileFactory profileFactory = new ProfileFactory();
        em.persist(profileFactory.getProfile());
    }

}