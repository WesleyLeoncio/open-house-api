package wl.open_house_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wl.open_house_api.model.role.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
