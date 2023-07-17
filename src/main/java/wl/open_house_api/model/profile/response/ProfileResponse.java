package wl.open_house_api.model.profile.response;

import wl.open_house_api.model.profile.entity.ProfileId;
import wl.open_house_api.model.role.entity.Role;
import wl.open_house_api.model.usuario.entity.Usuario;

public record ProfileResponse(ProfileId profileId, Usuario usuario, Role role) {
}
