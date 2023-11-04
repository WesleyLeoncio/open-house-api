package wl.open_house_api.modules.token.service;

import wl.open_house_api.modules.usuario.model.entity.Usuario;


public interface ITokenService {

    String gerarToken(Usuario usuario);

    String getSubject(String tokenJWT);

}
