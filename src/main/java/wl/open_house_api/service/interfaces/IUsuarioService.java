package wl.open_house_api.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import wl.open_house_api.model.usuario.entity.Usuario;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatMaster;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatUser;
import wl.open_house_api.model.usuario.request.UsuarioRequestEditMaster;
import wl.open_house_api.model.usuario.response.UsuarioResponse;
import wl.open_house_api.model.usuario.response.UsuarioResponseCrud;


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
