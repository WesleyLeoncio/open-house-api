package wl.open_house_api.modules.role.model.mapper;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wl.open_house_api.modules.role.factory.RoleFactory;
import wl.open_house_api.modules.role.model.entity.Role;
import wl.open_house_api.modules.role.model.enuns.Roles;
import wl.open_house_api.modules.role.model.response.RoleResponse;

import static org.assertj.core.api.Assertions.assertThat;

class RoleMapperTest {

    private RoleFactory roleFactory;

    @BeforeEach
    public void beforeEach(){
        this.roleFactory = new RoleFactory();
    }

    @Test
    @DisplayName("Deveria converter um RoleRequestCreat em uma entity Role")
    void roleRequestCreatToRole() {
        Role role = RoleMapper.INSTANCE.roleRequestCreatToRole(roleFactory.getRoleRequestCreat());

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

        assertThat( roleResponse.id()).isEqualTo( 1L );
        assertThat( roleResponse.nome()).isEqualTo( "ROLE_USER" );
    }
}