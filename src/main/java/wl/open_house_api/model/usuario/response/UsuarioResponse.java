package wl.open_house_api.model.usuario.response;

import wl.open_house_api.model.role.response.RoleResponseUser;

import java.util.List;

public record UsuarioResponse(Long id, String nome, String login, List<RoleResponseUser> role, Boolean status) {
}
