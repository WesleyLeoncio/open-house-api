package wl.open_house_api.model.usuario.response;

import wl.open_house_api.model.profile.response.ProfileResponse;

public record UsuarioResponse(Long id, String nome, String login, ProfileResponse profile, Boolean status) {
}
