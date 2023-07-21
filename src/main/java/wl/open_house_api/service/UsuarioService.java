package wl.open_house_api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wl.open_house_api.model.profile.request.ProfileRequest;
import wl.open_house_api.model.profile.request.ProfileRequestRole;
import wl.open_house_api.model.profile.request.ProfileRequestUser;
import wl.open_house_api.model.usuario.entity.Usuario;
import wl.open_house_api.model.usuario.mapper.UsuarioMapper;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatMaster;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatUser;
import wl.open_house_api.model.usuario.request.UsuarioRequestEditMaster;
import wl.open_house_api.model.usuario.response.UsuarioResponse;
import wl.open_house_api.model.usuario.response.UsuarioResponseCrud;
import wl.open_house_api.repository.UsuarioRepository;
import wl.open_house_api.service.interfaces.UsuarioServiceMetodos;

import java.util.List;

@Service
public class UsuarioService implements UsuarioServiceMetodos {

    final UsuarioRepository repository;

    final ProfileService profileService;


    public UsuarioService(UsuarioRepository repository, ProfileService profileService) {
        this.repository = repository;
        this.profileService = profileService;
    }

    @Override
    @Transactional
    public UsuarioResponseCrud insert(UsuarioRequestCreatMaster user) {
        Usuario usuario = repository.save(UsuarioMapper.INSTANCE.usuarioResquestCreatMasterToUsuario(user));
        adicionarProfiles(usuario, user.rolesList());
        return UsuarioMapper.INSTANCE.usuarioToUsuarioResponseCrud(usuario);
    }

    @Override
    @Transactional
    public UsuarioResponseCrud insertUserProfileUser(UsuarioRequestCreatUser user) {
        Usuario usuario = repository.save(UsuarioMapper.INSTANCE.usuarioResquestCreatUserToUsuario(user));
        adicionarProfileUser(usuario);
        return UsuarioMapper.INSTANCE.usuarioToUsuarioResponseCrud(usuario);
    }

    @Override
    @Transactional
    public UsuarioResponseCrud update(UsuarioRequestEditMaster user) {
        Usuario usuario = verificarUser(user.id());
        usuario.atualizarDados(user);
        return UsuarioMapper.INSTANCE.usuarioToUsuarioResponseCrud(usuario);
    }

    @Override
    @Transactional
    public UsuarioResponse findUser(Long id) {
        Usuario usuario = repository.getReferenceById(id);
        return UsuarioMapper.INSTANCE.usuarioToUsuarioResponse(usuario);
    }

    @Override
    public Page<UsuarioResponse> findUsers(Pageable pageable) {
        return repository.findAll(pageable).map(UsuarioMapper.INSTANCE::usuarioToUsuarioResponse);
    }

    @Override
    public Page<UsuarioResponse> findUsersStatusTrue(Pageable pageable) {
        return repository.findAllByStatusTrue(pageable).map(UsuarioMapper.INSTANCE::usuarioToUsuarioResponse);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        repository.delete(verificarUser(id));
    }

    @Override
    @Transactional
    public void modifyStatus(Long id) {
        Usuario usuario = repository.getReferenceById(id);
        usuario.setStatus(!usuario.getStatus());
        repository.save(usuario);
    }

    public Usuario verificarUser(Long id) {
        return repository.getReferenceById(id);
    }

    public Boolean usuarioAtivo(Long id) {
        return true;
    }

    public void adicionarProfiles(Usuario usuario, List<ProfileRequestRole> roles) {
        roles.forEach(r -> profileService.adicionarProfile(new ProfileRequest(usuario.getId(), r.roleId())));
    }

    public void adicionarProfileUser(Usuario usuario) {
        profileService.adicionarProfileUser(new ProfileRequestUser(usuario.getId()));
    }
}
