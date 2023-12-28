package wl.open_house_api.modules.role.factory;

import wl.open_house_api.modules.role.model.entity.Role;
import wl.open_house_api.modules.role.model.enuns.Roles;
import wl.open_house_api.modules.role.model.request.RoleRequest;
import wl.open_house_api.modules.role.model.request.RoleRequestCreat;
import wl.open_house_api.modules.role.model.response.RoleResponse;

import java.util.ArrayList;
import java.util.List;

public class RoleFactory {

    private final Long id;
    private final Roles nome;


    public RoleFactory() {
        this.id = 1L;
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

    public RoleRequestCreat getRoleRequestCreat(){
        return new RoleRequestCreat(this.nome);
    }

    public RoleRequest getRoleRequest(){
        return new RoleRequest(this.id,this.nome);
    }

    public List<RoleRequest> getRoleRequestList(){
        List<RoleRequest> roleRequestList = new ArrayList<>();
        roleRequestList.add(getRoleRequest());
        return roleRequestList;
    }

    public RoleResponse getRoleResponse(){
        return new RoleResponse(1L, this.nome.toString());
    }


    public List<RoleResponse> getListRoleResponseUser(){
        List<RoleResponse> listRoleUser = new ArrayList<>();
        listRoleUser.add(getRoleResponse());
        return listRoleUser;
    }
}
