package wl.open_house_api.modules.usuario.factory;

import wl.open_house_api.modules.profile.factory.ProfileFactory;
import wl.open_house_api.modules.role.factory.RoleFactory;
import wl.open_house_api.modules.usuario.model.entity.Usuario;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestCreatMaster;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestCreatUser;
import wl.open_house_api.modules.usuario.model.response.UsuarioResponse;
import wl.open_house_api.modules.usuario.model.response.UsuarioResponseCrud;

public class UsuarioFactory {
    private final Long id;
    private final String nome;
    private final String login;
    private final String senha;
    private final Boolean status;

    public UsuarioFactory() {
        this.id = 1L;
        this.nome = "Usuario";
        this.login = "usuario@email.com";
        this.senha = "123456";
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
        return new Usuario(this.id, this.nome, this.login,this.senha);
    }

    public UsuarioResponse getUsuarioResponse(){
        RoleFactory roleFactory = new RoleFactory();
        return new UsuarioResponse(this.id, this.nome,this.login, roleFactory.getListRoleResponseUser(), status);
    }

    public UsuarioResponseCrud getUsuarioResponseCrud(){
        return new UsuarioResponseCrud(this.id, this.nome,this.login, status);
    }

    public Usuario getUsuarioRoles(){
        Usuario usuario = new Usuario(this.id, this.nome, this.login,this.senha);
        RoleFactory roleFactory = new RoleFactory();
        usuario.setRole(roleFactory.getRoleList());
        return usuario;
    }

}
