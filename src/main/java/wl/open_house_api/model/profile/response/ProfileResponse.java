package wl.open_house_api.model.profile.response;
import wl.open_house_api.model.role.response.RoleResponse;
import wl.open_house_api.model.usuario.response.UsuarioResponse;

public record ProfileResponse(UsuarioResponse usuario, RoleResponse role) {
}
