package wl.open_house_api.modules.usuario.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wl.open_house_api.infra.exeptions.ObjectNotFoundExeption;
import wl.open_house_api.modules.role.service.IRoleService;
import wl.open_house_api.modules.usuario.model.entity.Usuario;
import wl.open_house_api.modules.usuario.model.mapper.UsuarioMapper;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestCreatMaster;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestCreatUser;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestEditMaster;
import wl.open_house_api.modules.usuario.model.response.UsuarioResponse;
import wl.open_house_api.modules.usuario.repository.UsuarioRepository;

import java.util.Collections;
import java.util.UUID;

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

    @Override //TODO REFATORAR
    @Transactional
    public UsuarioResponse insertUserProfileUser(UsuarioRequestCreatUser user) {
        Usuario usuario = UsuarioMapper.INSTANCE.usuarioResquestCreatUserToUsuario(user);
        usuario.setSenha(passwordEncoder.encode(usuario.getPassword()));
        usuario.setRoles(Collections.singletonList(roleService.verificarRole(UUID.fromString("c3c5358a-0d93-4132-8d33-cad1a453d440"))));

        return UsuarioMapper.INSTANCE.usuarioToUsuarioResponse(repository.save(usuario));
    }

    @Override
    @Transactional
    public UsuarioResponse update(UUID id, UsuarioRequestEditMaster usuarioRequest) {
        verificarUser(id);
        Usuario usuario = UsuarioMapper.INSTANCE.usuarioRequestEditMasterToUsuario(usuarioRequest);
        usuario.setId(id);
        usuario.setSenha(passwordEncoder.encode(usuarioRequest.senha()));
        return UsuarioMapper.INSTANCE.usuarioToUsuarioResponse(repository.save(usuario));
    }


    @Override
    @Transactional
    public UsuarioResponse findUser(UUID id) {
        return UsuarioMapper.INSTANCE.usuarioToUsuarioResponse(verificarUser(id));
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
    public void deleteUser(UUID id) {
        repository.delete(verificarUser(id));
    }

    @Override
    @Transactional
    public void modifyStatus(UUID id) {
        Usuario usuario = verificarUser(id);
        usuario.setStatus(!usuario.getStatus());
        repository.save(usuario);
    }


    public Usuario verificarUser(UUID id) {
        return repository.findById(id).orElseThrow(ObjectNotFoundExeption::new);
    }

    public Boolean usuarioAtivo(UUID id) {
        return repository.findStatusById(id);
    }



}
