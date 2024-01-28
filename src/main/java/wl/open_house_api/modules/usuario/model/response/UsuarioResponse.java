package wl.open_house_api.modules.usuario.model.response;


import wl.open_house_api.modules.role.model.response.RoleResponse;

import java.util.List;

public record UsuarioResponse(Long id, String nome, String login, List<RoleResponse> roles, Boolean status) {
}
