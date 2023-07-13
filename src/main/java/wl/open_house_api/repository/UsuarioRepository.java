package wl.open_house_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wl.open_house_api.model.usuario.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
