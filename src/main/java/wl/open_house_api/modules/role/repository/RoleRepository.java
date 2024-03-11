package wl.open_house_api.modules.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wl.open_house_api.modules.role.model.entity.Role;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
}
