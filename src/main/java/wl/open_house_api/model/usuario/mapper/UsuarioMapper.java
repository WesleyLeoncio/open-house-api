package wl.open_house_api.model.usuario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import wl.open_house_api.model.usuario.entity.Usuario;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatMaster;


@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper( UsuarioMapper.class );

    Usuario usuarioResquestCreatMasterToUsuario(UsuarioRequestCreatMaster usuarioRequestCreatMaster);


}
