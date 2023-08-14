package wl.open_house_api.service.interfaces;

import wl.open_house_api.model.usuario.entity.Usuario;


public interface ITokenService {

    String gerarToken(Usuario usuario);

    String getSubject(String tokenJWT);

}
