package wl.open_house_api.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatMaster;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatUser;
import wl.open_house_api.model.usuario.request.UsuarioRequestEditMaster;
import wl.open_house_api.model.usuario.response.UsuarioResponse;
import wl.open_house_api.model.usuario.response.UsuarioResponseCrud;


public interface UsuarioServiceCrud {

    public UsuarioResponseCrud insert(UsuarioRequestCreatMaster user);

    public UsuarioResponseCrud insertUserProfileUser(UsuarioRequestCreatUser user);

    public UsuarioResponseCrud update(UsuarioRequestEditMaster user);

    public UsuarioResponse findUser(Long id);

    Page<UsuarioResponse> findUsers(Pageable pageable);
    Page<UsuarioResponse> findUsersStatusTrue(Pageable pageable);

    public void deleteUser(Long id);

    public void modifyStatus(Long id);



}
