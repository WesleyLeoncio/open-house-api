package wl.open_house_api.modules.profile.model.response;
import wl.open_house_api.modules.role.model.response.RoleResponse;
import wl.open_house_api.modules.usuario.model.response.UsuarioResponse;

public record ProfileResponse(UsuarioResponse usuario, RoleResponse role) {
}
