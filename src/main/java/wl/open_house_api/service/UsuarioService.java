package wl.open_house_api.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wl.open_house_api.model.usuario.entity.Usuario;
import wl.open_house_api.model.usuario.mapper.UsuarioMapper;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatMaster;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatUser;
import wl.open_house_api.model.usuario.request.UsuarioRequestEditMaster;
import wl.open_house_api.model.usuario.response.UsuarioResponse;
import wl.open_house_api.repository.UsuarioRepository;
import wl.open_house_api.service.interfaces.UsuarioServiceCrud;

import java.util.Optional;

@Service
public class UsuarioService implements UsuarioServiceCrud {

    final UsuarioRepository repository;

    final ProfileService serviceProfile;

    public UsuarioService(UsuarioRepository repository, ProfileService serviceProfile) {
        this.repository = repository;
        this.serviceProfile = serviceProfile;
    }

    @Override
    @Transactional
    public UsuarioResponse insert(UsuarioRequestCreatMaster user) {
        serviceProfile.verificiarProfile(user.profile().id());
        Usuario usuario = repository.save(UsuarioMapper.INSTANCE.usuarioResquestCreatMasterToUsuario(user));
        return UsuarioMapper.INSTANCE.usuarioToUsuarioResponse(usuario);
    }

    @Override
    public UsuarioResponse insertUserProfileUser(UsuarioRequestCreatUser user) {
        Usuario usuario = UsuarioMapper.INSTANCE.usuarioResquestCreatUserToUsuario(user);
        usuario.setProfile(serviceProfile.verificiarProfile(3L));
        return UsuarioMapper.INSTANCE.usuarioToUsuarioResponse(repository.save(usuario));
    }

    @Override
    @Transactional
    public UsuarioResponse update(UsuarioRequestEditMaster user) {
        verificarUser(user.id());
        serviceProfile.verificiarProfile(user.profile().id());
        Usuario usuario = repository.save(UsuarioMapper.INSTANCE.usuarioResquestEditMasterToUsuario(user));
        return UsuarioMapper.INSTANCE.usuarioToUsuarioResponse(usuario);
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
            throw new EntityNotFoundException();
        }
        return usuario.get();
    }

    public Boolean usuarioAtivo(Long id){
        return repository.findStatusById(id);
    }
}
