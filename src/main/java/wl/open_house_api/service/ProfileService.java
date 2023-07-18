package wl.open_house_api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wl.open_house_api.infra.exeptions.ValidacaoException;
import wl.open_house_api.model.profile.entity.Profile;
import wl.open_house_api.model.profile.entity.ProfileId;
import wl.open_house_api.model.profile.mapper.ProfileMapper;
import wl.open_house_api.model.profile.request.ProfileRequest;
import wl.open_house_api.model.profile.request.ProfileRequestUser;
import wl.open_house_api.model.profile.response.ProfileResponse;
import wl.open_house_api.model.role.entity.Role;
import wl.open_house_api.model.usuario.entity.Usuario;
import wl.open_house_api.repository.ProfileRepository;
import wl.open_house_api.repository.UsuarioRepository;
import wl.open_house_api.service.interfaces.ProfileServiceMetodos;

import java.util.Optional;

@Service
public class ProfileService implements ProfileServiceMetodos {

    final ProfileRepository repository;

    final UsuarioRepository usuarioRepository;

    final RoleService serviceRole;

    public ProfileService(ProfileRepository repository, UsuarioRepository usuarioRepository, RoleService serviceRole) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
        this.serviceRole = serviceRole;
    }

    @Override
    @Transactional
    public ProfileResponse adicionarProfile(ProfileRequest profileRequest) {
        Profile profile = profileFactory(profileRequest);
        return ProfileMapper.INSTANCE.profileToProfileResponse(repository.save(profile));
    }

    @Override
    @Transactional
    public ProfileResponse adicionarProfileUser(ProfileRequestUser profileRequestUser) {
        Profile profile = profileFactoryUser(profileRequestUser);
        return ProfileMapper.INSTANCE.profileToProfileResponse(repository.save(profile));
    }

    @Override
    @Transactional
    public void removerProfile(ProfileRequest profileRequest) {
        repository.delete(profileFactory(profileRequest));
    }


    public Profile profileFactory(ProfileRequest profileRequest) {
        Usuario usuario = verificiarUsuario(profileRequest.usuarioId());
        Role role = serviceRole.verificiarRole(profileRequest.roleId());
        ProfileId profileId = new ProfileId(usuario.getId(),role.getId());
        return new Profile(profileId, usuario,role);
    }

    public Profile profileFactoryUser(ProfileRequestUser profileRequestUser) {
        Usuario usuario = verificiarUsuario(profileRequestUser.usuarioId());
        Role role = serviceRole.verificiarRole(3L);
        ProfileId profileId = new ProfileId(usuario.getId(),role.getId());
        return new Profile(profileId,usuario,role);
    }

    public Usuario verificiarUsuario(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty()){
            throw new ValidacaoException("Usuario não existe, verifique e tente e novamente!");
        }
        return usuario.get();
    }

}
