package wl.open_house_api.modules.profile.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wl.open_house_api.infra.exeptions.ValidacaoException;
import wl.open_house_api.modules.profile.model.entity.Profile;
import wl.open_house_api.modules.profile.model.entity.ProfileId;
import wl.open_house_api.modules.profile.model.mapper.ProfileMapper;
import wl.open_house_api.modules.profile.model.request.ProfileRequest;
import wl.open_house_api.modules.profile.model.request.ProfileRequestUser;
import wl.open_house_api.modules.profile.model.response.ProfileResponse;
import wl.open_house_api.modules.role.model.entity.Role;
import wl.open_house_api.modules.usuario.model.entity.Usuario;
import wl.open_house_api.modules.profile.repository.ProfileRepository;
import wl.open_house_api.modules.usuario.repository.UsuarioRepository;
import wl.open_house_api.modules.role.service.IRoleService;

import java.util.Optional;


@Service
public class ProfileService implements IProfileService {

    final ProfileRepository repository;

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
