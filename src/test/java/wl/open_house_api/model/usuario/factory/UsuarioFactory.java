package wl.open_house_api.model.usuario.factory;

import wl.open_house_api.model.profile.factory.ProfileFactory;
import wl.open_house_api.model.role.entity.Role;
import wl.open_house_api.model.role.factory.RoleFactory;
import wl.open_house_api.model.usuario.entity.Usuario;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatMaster;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatUser;
import wl.open_house_api.model.usuario.response.UsuarioResponse;
import wl.open_house_api.model.usuario.response.UsuarioResponseCrud;

import java.util.List;

public class UsuarioFactory {
    private final Long id;
    private final String nome;
    private final String login;
    private final String senha;
    private final List<Role> role;
    private final Boolean status;

    public UsuarioFactory() {
        RoleFactory roleFactory = new RoleFactory();
        this.id = 1L;
        this.nome = "Usuario";
        this.login = "usuario@email.com";
        this.senha = "123456";
        this.role = roleFactory.getRoleList();
        this.status = true;
    }

    public UsuarioRequestCreatUser getUsuarioRequestCreatUser(){
        return new UsuarioRequestCreatUser(this.nome, this.login,this.senha);
    }

    public UsuarioRequestCreatMaster getUsuarioRequestCreatMaster(){
        ProfileFactory profileFactory = new ProfileFactory();
        return new UsuarioRequestCreatMaster(this.nome, this.login,this.senha, profileFactory.getlistProfileRequestRole());
    }

    public Usuario getUsuario(){
        return new Usuario(this.id, this.nome, this.login,this.senha,this.role);
    }

    public UsuarioResponse getUsuarioResponse(){
        RoleFactory roleFactory = new RoleFactory();
        return new UsuarioResponse(this.id, this.nome,this.login, roleFactory.getListRoleResponseUser(), status);
    }

    public UsuarioResponseCrud getUsuarioResponseCrud(){
        return new UsuarioResponseCrud(this.id, this.nome,this.login, status);
    }


}
