package wl.open_house_api.modules.usuario.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wl.open_house_api.infra.exeptions.ValidacaoException;
import wl.open_house_api.modules.role.service.IRoleService;
import wl.open_house_api.modules.usuario.model.entity.Usuario;
import wl.open_house_api.modules.usuario.model.mapper.UsuarioMapper;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestCreatMaster;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestCreatUser;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestEditMaster;
import wl.open_house_api.modules.usuario.model.response.UsuarioResponse;
import wl.open_house_api.modules.usuario.repository.UsuarioRepository;

import java.util.Collections;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    final UsuarioRepository repository;

    final IRoleService roleService;

    final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repository, IRoleService roleService, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UsuarioResponse insert(UsuarioRequestCreatMaster user) {
        Usuario usuario = UsuarioMapper.INSTANCE.usuarioResquestCreatMasterToUsuario(user);
        usuario.setSenha(passwordEncoder.encode(usuario.getPassword()));
        return UsuarioMapper.INSTANCE.usuarioToUsuarioResponse(repository.save(usuario));
    }

    @Override
    @Transactional
    public UsuarioResponse insertUserProfileUser(UsuarioRequestCreatUser user) {
        Usuario usuario = UsuarioMapper.INSTANCE.usuarioResquestCreatUserToUsuario(user);
        usuario.setSenha(passwordEncoder.encode(usuario.getPassword()));
        usuario.setRole(Collections.singletonList(roleService.verificarRole(3L)));

        return UsuarioMapper.INSTANCE.usuarioToUsuarioResponse(repository.save(usuario));
    }

    @Override
    @Transactional
    public UsuarioResponse update(UsuarioRequestEditMaster user) {
        verificarUser(user.id());
        Usuario usuario = UsuarioMapper.INSTANCE.usuarioRequestEditMasterToUsuario(user);
        usuario.setSenha(passwordEncoder.encode(user.senha()));
        return UsuarioMapper.INSTANCE.usuarioToUsuarioResponse(repository.save(usuario));
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
        Optional<Usuario> usuario = repository.findById(id);
        if (usuario.isEmpty()) {
            throw new ValidacaoException("Usuario não existe, verifique e tente e novamente!");
        }
        return usuario.get();
    }

    public Boolean usuarioAtivo(Long id) {
        return repository.findStatusById(id);
    }



}
