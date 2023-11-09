package wl.open_house_api.modules.usuario.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import wl.open_house_api.modules.usuario.model.entity.Usuario;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestCreatMaster;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestCreatUser;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestEditMaster;
import wl.open_house_api.modules.usuario.model.response.UsuarioResponse;
import wl.open_house_api.modules.usuario.model.response.UsuarioResponseCrud;

public interface IUsuarioService {

    UsuarioResponseCrud insert(UsuarioRequestCreatMaster user);

    UsuarioResponseCrud insertUserProfileUser(UsuarioRequestCreatUser user);

    UsuarioResponseCrud update(UsuarioRequestEditMaster user);

    UsuarioResponse findUser(Long id);

    Page<UsuarioResponse> findUsers(Pageable pageable);

    Page<UsuarioResponse> findUsersStatusTrue(Pageable pageable);

    void deleteUser(Long id);

    void modifyStatus(Long id);

    Usuario verificarUser(Long id);


}
