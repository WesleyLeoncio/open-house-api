package wl.open_house_api.modules.role.factory;

import wl.open_house_api.modules.role.model.entity.Role;
import wl.open_house_api.modules.role.model.enuns.Roles;
import wl.open_house_api.modules.role.model.mapper.RoleMapper;
import wl.open_house_api.modules.role.model.request.RoleRequest;
import wl.open_house_api.modules.role.model.request.RoleUserRequest;
import wl.open_house_api.modules.role.model.response.RoleResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RoleFactory {

    private final UUID id;
    private final Roles nome;


    public RoleFactory() {
        this.id = UUID.fromString("c3c5358a-0d93-4132-8d33-cad1a453d440");
        this.nome = Roles.ROLE_USER;
    }

    public Role getRole(){
        return new Role(this.id, this.nome);
    }

    public List<Role> getRoleList(){
        List<Role> roleList = new ArrayList<>();
        roleList.add(getRole());
        return roleList;
    }

    public List<RoleUserRequest> getRoleListUser(){
        return RoleMapper.INSTANCE.roleToRoleUserRequest(this.getRoleList());
    }


    public RoleRequest getRoleRequest(){
        return new RoleRequest(this.nome);
    }



    public RoleResponse getRoleResponse(){
        return new RoleResponse(this.id, this.nome.toString());
    }


    public List<RoleResponse> getListRoleResponseUser(){
        List<RoleResponse> listRoleUser = new ArrayList<>();
        listRoleUser.add(getRoleResponse());
        return listRoleUser;
    }
}
