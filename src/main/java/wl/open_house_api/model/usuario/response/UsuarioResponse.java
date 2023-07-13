package wl.open_house_api.model.usuario.response;

import wl.open_house_api.model.profile.entity.Profile;

public record UsuarioResponse(Long id, String nome, String login, Profile profile, Boolean status) {
}
