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
import wl.open_house_api.service.interfaces.IProfileService;
import wl.open_house_api.service.interfaces.IRoleService;

import java.util.Optional;


@Service
public class ProfileService implements IProfileService {

    final ProfileRepository repository;

    //TODO TESTER COM ITERFACE
    final UsuarioRepository usuarioRepository;

    final IRoleService roleService;

    public ProfileService(ProfileRepository repository, UsuarioRepository usuarioRepository, IRoleService roleService) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
        this.roleService = roleService;
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


    private Profile profileFactory(ProfileRequest profileRequest) {
        Usuario usuario = verificarUsuario(profileRequest.usuarioId());
        Role role = roleService.verificarRole(profileRequest.roleId());
        ProfileId profileId = new ProfileId(usuario.getId(),role.getId());
        return new Profile(profileId, usuario,role);
    }

    private Profile profileFactoryUser(ProfileRequestUser profileRequestUser) {
        Usuario usuario = verificarUsuario(profileRequestUser.usuarioId());
        Role role = roleService.verificarRole(3L);
        ProfileId profileId = new ProfileId(usuario.getId(),role.getId());
        return new Profile(profileId,usuario,role);
    }

    private Usuario verificarUsuario(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty()){
            throw new ValidacaoException("Usuario não existe, verifique e tente e novamente!");
        }
        return usuario.get();
    }
}
