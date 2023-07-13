package wl.open_house_api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wl.open_house_api.model.usuario.entity.Usuario;
import wl.open_house_api.model.usuario.mapper.UsuarioMapper;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatMaster;
import wl.open_house_api.model.usuario.request.UsuarioRequestEditMaster;
import wl.open_house_api.model.usuario.response.UsuarioResponse;
import wl.open_house_api.repository.UsuarioRepository;
import wl.open_house_api.service.interfaces.UsuarioServiceCrud;

@Service
public class UsuarioService implements UsuarioServiceCrud {

    final private UsuarioRepository repository;

    final private ProfileService serviceProfile;

    public UsuarioService(UsuarioRepository repository, ProfileService serviceProfile) {
        this.repository = repository;
        this.serviceProfile = serviceProfile;
    }

    @Override
    public UsuarioResponse insert(UsuarioRequestCreatMaster user) {
        serviceProfile.existProfile(user.profile().getId());
        Usuario usuario = repository.save(UsuarioMapper.INSTANCE.usuarioResquestCreatMasterToUsuario(user));
        return UsuarioMapper.INSTANCE.usuarioToUsuarioResponse(usuario);
    }

    @Override
    public UsuarioResponse update(UsuarioRequestEditMaster user) {
        return null;
    }

    @Override
    public UsuarioResponse findUser(Long id) {
        return null;
    }

    @Override
    public Page<UsuarioResponse> findUsers(Pageable pageable) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public UsuarioResponse disableUser() {
        return null;
    }
}
