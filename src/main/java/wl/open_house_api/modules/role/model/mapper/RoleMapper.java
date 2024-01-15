package wl.open_house_api.modules.role.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import wl.open_house_api.modules.role.model.entity.Role;
import wl.open_house_api.modules.role.model.request.RoleRequest;
import wl.open_house_api.modules.role.model.request.RoleUserRequest;
import wl.open_house_api.modules.role.model.response.RoleResponse;

import java.util.List;


@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role roleRequestToRole(RoleRequest roleRequest);

    RoleResponse roleToRoleResponse(Role role);

    List<RoleUserRequest> roleToRoleUserRequest(List<Role> roles);


}
