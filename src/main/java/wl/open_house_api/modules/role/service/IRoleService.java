package wl.open_house_api.modules.role.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import wl.open_house_api.modules.role.model.entity.Role;
import wl.open_house_api.modules.role.model.request.RoleRequest;
import wl.open_house_api.modules.role.model.response.RoleResponse;

import java.util.UUID;

public interface IRoleService {

    RoleResponse insert(RoleRequest request);

    RoleResponse update(UUID id, RoleRequest roleRequest);

    RoleResponse findRole(UUID id);

    Page<RoleResponse> findRoles(Pageable pageable);

    void deleteRole(UUID id);

    Role verificarRole(UUID id);
}
