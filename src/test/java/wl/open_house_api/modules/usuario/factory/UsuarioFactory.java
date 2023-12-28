package wl.open_house_api.modules.usuario.factory;

import wl.open_house_api.modules.role.factory.RoleFactory;
import wl.open_house_api.modules.usuario.model.entity.Usuario;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestCreatMaster;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestCreatUser;
import wl.open_house_api.modules.usuario.model.response.UsuarioResponse;

public class UsuarioFactory {
    private final Long id;
    private final String nome;
    private final String login;
    private final String senha;
    private final Boolean status;
    RoleFactory roleFactory = new RoleFactory();

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
        return new UsuarioRequestCreatMaster(this.nome, this.login,this.senha, roleFactory.getRoleRequestList());
    }

    public Usuario getUsuario(){
        return new Usuario(this.id, this.nome, this.login,this.senha);
    }

    public UsuarioResponse getUsuarioResponse(){
        return new UsuarioResponse(this.id, this.nome,this.login, roleFactory.getListRoleResponseUser(), status);
    }


    public Usuario getUsuarioRoles(){
        Usuario usuario = new Usuario(this.id, this.nome, this.login,this.senha);
        RoleFactory roleFactory = new RoleFactory();
        usuario.setRole(roleFactory.getRoleList());
        return usuario;
    }

}
