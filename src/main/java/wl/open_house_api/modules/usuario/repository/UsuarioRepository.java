package wl.open_house_api.modules.usuario.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import wl.open_house_api.modules.usuario.model.entity.Usuario;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    UserDetails findByLogin(String username);

    Page<Usuario> findAllByStatusTrue(Pageable pageable);

    @Query("""
        SELECT u.status FROM Usuario u
          WHERE u.id = :id
    """)
    Boolean findStatusById(UUID id);

}
