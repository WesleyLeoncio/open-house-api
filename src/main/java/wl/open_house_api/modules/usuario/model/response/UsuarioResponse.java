package wl.open_house_api.modules.usuario.model.response;


import wl.open_house_api.modules.role.model.response.RoleResponse;

import java.util.List;
import java.util.UUID;

public record UsuarioResponse(UUID id, String nome, String login, List<RoleResponse> roles, Boolean status) {
}
