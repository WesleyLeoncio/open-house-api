package wl.open_house_api.modules.role.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import wl.open_house_api.modules.role.model.entity.Role;
import wl.open_house_api.modules.role.model.request.RoleRequest;
import wl.open_house_api.modules.role.model.response.RoleResponse;

public interface IRoleService {

    RoleResponse insert(RoleRequest request);

    RoleResponse update(Long id, RoleRequest roleRequest);

    RoleResponse findRole(Long id);

    Page<RoleResponse> findRoles(Pageable pageable);

    void deleteRole(Long id);

    Role verificarRole(Long id);
}
