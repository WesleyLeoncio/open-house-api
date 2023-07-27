package wl.open_house_api.model.profile.factory;

import wl.open_house_api.model.profile.entity.Profile;
import wl.open_house_api.model.profile.entity.ProfileId;
import wl.open_house_api.model.profile.request.ProfileRequestRole;
import wl.open_house_api.model.profile.response.ProfileResponse;
import wl.open_house_api.model.role.entity.Role;
import wl.open_house_api.model.role.factory.RoleFactory;
import wl.open_house_api.model.usuario.entity.Usuario;
import wl.open_house_api.model.usuario.factory.UsuarioFactory;

import java.util.ArrayList;
import java.util.List;


public class ProfileFactory {

    private Usuario usuario;
    private Role role;

    public ProfileFactory() {
        RoleFactory roleFactory = new RoleFactory();
        UsuarioFactory usuarioFactory = new UsuarioFactory();
        this.role = roleFactory.getRole();
        this.usuario = usuarioFactory.getUsuario();

    }

    public ProfileRequestRole getProfileRequestRole(){
        return new ProfileRequestRole(this.role.getId());
    }

    public List<ProfileRequestRole> getlistProfileRequestRole(){
        List<ProfileRequestRole> roles = new ArrayList<>();
        roles.add(getProfileRequestRole());
        return roles;
    }

    public ProfileResponse getProfileResponse(){
        UsuarioFactory usuarioFactory = new UsuarioFactory();
        RoleFactory roleFactory = new RoleFactory();
        return new ProfileResponse(usuarioFactory.getUsuarioResponse(),roleFactory.getRoleResponse());
    }


    public Profile getProfile(){
        ProfileId profileId = new ProfileId(this.usuario.getId(), role.getId());
        return new Profile(profileId, this.usuario, this.role);
    }

}
