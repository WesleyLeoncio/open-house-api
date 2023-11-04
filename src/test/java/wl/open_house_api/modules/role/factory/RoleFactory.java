package wl.open_house_api.modules.role.factory;

import wl.open_house_api.modules.role.model.entity.Role;
import wl.open_house_api.modules.role.model.request.RoleRequest;
import wl.open_house_api.modules.role.model.request.RoleRequestCreat;
import wl.open_house_api.modules.role.model.response.RoleResponse;
import wl.open_house_api.modules.role.model.response.RoleResponseUser;

import java.util.ArrayList;
import java.util.List;

public class RoleFactory {

    private final Long id;
    private final String nome;


    public RoleFactory() {
        this.id = 1L;
        this.nome = "ROLE_USER";
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

    public RoleResponseUser getRoleResponseUser(){
        return new RoleResponseUser(this.nome);
    }

    public RoleResponse getRoleResponse(){
        return new RoleResponse(this.id,this.nome);
    }

    public List<RoleResponseUser> getListRoleResponseUser(){
        List<RoleResponseUser> listRoleUser = new ArrayList<>();
        listRoleUser.add(getRoleResponseUser());
        return listRoleUser;
    }
}
