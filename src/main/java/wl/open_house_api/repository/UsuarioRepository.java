package wl.open_house_api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wl.open_house_api.model.usuario.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Page<Usuario> findAllByStatusTrue(Pageable pageable);

    @Query("""
        SELECT u.status FROM Usuario u
          WHERE u.id = :id
    """)
    Boolean findStatusById(Long id);
}