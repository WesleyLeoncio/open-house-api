package wl.open_house_api.modules.profile.factory;

import wl.open_house_api.modules.profile.model.entity.Profile;
import wl.open_house_api.modules.profile.model.entity.ProfileId;
import wl.open_house_api.modules.profile.model.request.ProfileRequest;
import wl.open_house_api.modules.profile.model.request.ProfileRequestRole;
import wl.open_house_api.modules.profile.model.response.ProfileResponse;
import wl.open_house_api.modules.role.model.entity.Role;
import wl.open_house_api.modules.role.factory.RoleFactory;
import wl.open_house_api.modules.usuario.model.entity.Usuario;
import wl.open_house_api.modules.usuario.factory.UsuarioFactory;

import java.util.ArrayList;
import java.util.List;


public class ProfileFactory {

    private final Usuario usuario;
    private final Role role;

    public ProfileFactory() {
        RoleFactory roleFactory = new RoleFactory();
        UsuarioFactory usuarioFactory = new UsuarioFactory();
        this.role = roleFactory.getRole();
        this.usuario = usuarioFactory.getUsuario();

    }

    public ProfileRequestRole getProfileRequestRole(){
        return new ProfileRequestRole(this.role.getId());
    }

    public ProfileRequest getProfileRequest(){
        return new ProfileRequest(this.usuario.getId(),this.role.getId());
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
