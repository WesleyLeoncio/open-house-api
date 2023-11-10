package wl.open_house_api.modules.usuario.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wl.open_house_api.infra.exeptions.ValidacaoException;
import wl.open_house_api.modules.profile.service.IProfileService;
import wl.open_house_api.modules.profile.model.request.ProfileRequest;
import wl.open_house_api.modules.profile.model.request.ProfileRequestRole;
import wl.open_house_api.modules.profile.model.request.ProfileRequestUser;
import wl.open_house_api.modules.usuario.model.entity.Usuario;
import wl.open_house_api.modules.usuario.model.mapper.UsuarioMapper;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestCreatMaster;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestCreatUser;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestEditMaster;
import wl.open_house_api.modules.usuario.model.response.UsuarioResponse;
import wl.open_house_api.modules.usuario.model.response.UsuarioResponseCrud;
import wl.open_house_api.modules.usuario.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    final UsuarioRepository repository;

    final IProfileService profileService;

    final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repository, IProfileService profileService, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.profileService = profileService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UsuarioResponseCrud insert(UsuarioRequestCreatMaster user) {
        Usuario usuario = UsuarioMapper.INSTANCE.usuarioResquestCreatMasterToUsuario(user);
        usuario.setSenha(passwordEncoder.encode(usuario.getPassword()));

        Usuario cadastro = repository.save(usuario);

        adicionarProfiles(cadastro, user.rolesList());
        return UsuarioMapper.INSTANCE.usuarioToUsuarioResponseCrud(cadastro);
    }

    @Override
    @Transactional
    public UsuarioResponseCrud insertUserProfileUser(UsuarioRequestCreatUser user) {
        Usuario usuario = UsuarioMapper.INSTANCE.usuarioResquestCreatUserToUsuario(user);

        usuario.setSenha(passwordEncoder.encode(usuario.getPassword()));

        Usuario cadastro = repository.save(usuario);

        adicionarProfileUser(cadastro);

        return UsuarioMapper.INSTANCE.usuarioToUsuarioResponseCrud(cadastro);
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


    public Usuario verificarUser(Long id){
        Optional<Usuario> usuario = repository.findById(id);
        if(usuario.isEmpty()){
            throw new ValidacaoException("Usuario não existe, verifique e tente e novamente!");
        }
        return usuario.get();
    }

    public Boolean usuarioAtivo(Long id) {
        return repository.findStatusById(id);
    }

    private void adicionarProfiles(Usuario usuario, List<ProfileRequestRole> roles) {
        roles.forEach(r -> profileService.adicionarProfile(new ProfileRequest(usuario.getId(), r.roleId())));
    }

    private void adicionarProfileUser(Usuario usuario) {
        profileService.adicionarProfileUser(new ProfileRequestUser(usuario.getId()));
    }


}
