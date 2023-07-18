package wl.open_house_api.model.usuario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import wl.open_house_api.model.usuario.entity.Usuario;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatMaster;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatUser;
import wl.open_house_api.model.usuario.request.UsuarioRequestEditMaster;
import wl.open_house_api.model.usuario.response.UsuarioResponse;
import wl.open_house_api.model.usuario.response.UsuarioResponseCrud;


@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper( UsuarioMapper.class );

    Usuario usuarioResquestCreatMasterToUsuario(UsuarioRequestCreatMaster usuarioRequestCreatMaster);

    Usuario usuarioResquestCreatUserToUsuario(UsuarioRequestCreatUser usuarioRequestCreatUser);

    UsuarioResponseCrud usuarioToUsuarioResponseCrud(Usuario usuario);

    UsuarioResponse usuarioToUsuarioResponse(Usuario usuario);

}
