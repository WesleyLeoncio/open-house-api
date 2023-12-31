package wl.open_house_api.modules.usuario.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import wl.open_house_api.modules.usuario.model.entity.Usuario;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestEditMaster;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestCreatMaster;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestCreatUser;
import wl.open_house_api.modules.usuario.model.response.UsuarioResponse;


@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper( UsuarioMapper.class );

    Usuario usuarioResquestCreatMasterToUsuario(UsuarioRequestCreatMaster usuarioRequestCreatMaster);

    Usuario usuarioResquestCreatUserToUsuario(UsuarioRequestCreatUser usuarioRequestCreatUser);

    Usuario usuarioRequestEditMasterToUsuario(UsuarioRequestEditMaster usuarioRequestEditMaster);

    UsuarioResponse usuarioToUsuarioResponse(Usuario usuario);

}
