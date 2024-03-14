package wl.open_house_api.modules.usuario.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import wl.open_house_api.modules.usuario.model.entity.Usuario;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestCreatMaster;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestCreatUser;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestEditMaster;
import wl.open_house_api.modules.usuario.model.response.UsuarioResponse;

import java.util.UUID;

public interface IUsuarioService {

    UsuarioResponse insert(UsuarioRequestCreatMaster user);

    UsuarioResponse insertUserProfileUser(UsuarioRequestCreatUser user);

    UsuarioResponse update(UUID id, UsuarioRequestEditMaster user);

    UsuarioResponse findUser(UUID id);

    Page<UsuarioResponse> findUsers(Pageable pageable);

    Page<UsuarioResponse> findUsersStatusTrue(Pageable pageable);

    void deleteUser(UUID id);

    void modifyStatus(UUID id);

    Usuario verificarUser(UUID id);


}
