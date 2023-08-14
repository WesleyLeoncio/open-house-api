package wl.open_house_api.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import wl.open_house_api.model.role.entity.Role;
import wl.open_house_api.model.role.request.RoleRequest;
import wl.open_house_api.model.role.request.RoleRequestCreat;
import wl.open_house_api.model.role.response.RoleResponse;

public interface IRoleService {

    RoleResponse insert(RoleRequestCreat roleRequestCreat);

    RoleResponse update(RoleRequest roleRequest);

    RoleResponse findRole(Long id);

    Page<RoleResponse> findRoles(Pageable pageable);

    void deleteRole(Long id);

    Role verificiarRole(Long id);
}
