package wl.open_house_api.model.role.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import wl.open_house_api.model.role.entity.Role;
import wl.open_house_api.model.role.request.RoleRequest;
import wl.open_house_api.model.role.request.RoleRequestCreat;
import wl.open_house_api.model.role.response.RoleResponse;


@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role roleRequestCreatToRole(RoleRequestCreat roleRequestCreat);

    Role roleRequestToRole(RoleRequest roleRequest);

    RoleResponse roleToRoleResponse(Role role);


}
