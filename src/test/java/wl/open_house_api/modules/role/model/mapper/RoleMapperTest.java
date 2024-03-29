package wl.open_house_api.modules.role.model.mapper;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wl.open_house_api.modules.role.factory.RoleFactory;
import wl.open_house_api.modules.role.model.entity.Role;
import wl.open_house_api.modules.role.model.enuns.Roles;
import wl.open_house_api.modules.role.model.response.RoleResponse;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class RoleMapperTest {

    private RoleFactory roleFactory;

    @BeforeEach
    public void beforeEach(){
        this.roleFactory = new RoleFactory();
    }

    @Test
    @DisplayName("Deveria converter um RoleRequest em uma entity Role")
    void roleRequestCreatToRole() {
        Role role = RoleMapper.INSTANCE.roleRequestToRole(roleFactory.getRoleRequest());

        assertThat( role ).isNotNull();
        assertThat( role.getNome()).isEqualTo( Roles.ROLE_USER );
    }

    @Test
    @DisplayName("Deveria converter um RoleRequest em uma entity Role")
    void roleRequestToRole() {
        Role role = RoleMapper.INSTANCE.roleRequestToRole(roleFactory.getRoleRequest());

        assertThat( role ).isNotNull();
        assertThat( role.getNome()).isEqualTo( Roles.ROLE_USER );
    }

    @Test
    @DisplayName("Deveria converter um Role em uma entity RoleResponse")
    void roleToRoleResponse() {
        RoleResponse roleResponse = RoleMapper.INSTANCE.roleToRoleResponse(roleFactory.getRole());

        assertThat( roleResponse.id()).isEqualTo(UUID.fromString("c3c5358a-0d93-4132-8d33-cad1a453d440") );
        assertThat( roleResponse.nome()).isEqualTo( "ROLE_USER" );
    }
}