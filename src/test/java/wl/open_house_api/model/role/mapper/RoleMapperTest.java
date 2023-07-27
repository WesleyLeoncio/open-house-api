package wl.open_house_api.model.role.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wl.open_house_api.model.role.entity.Role;
import wl.open_house_api.model.role.factory.RoleFactory;
import wl.open_house_api.model.role.response.RoleResponse;
import static org.assertj.core.api.Assertions.assertThat;

class RoleMapperTest {

    @Test
    @DisplayName("Deveria converter um RoleRequestCreat em uma entity Role")
    void roleRequestCreatToRole() {
        RoleFactory roleFactory = new RoleFactory();

        Role role = RoleMapper.INSTANCE.roleRequestCreatToRole(roleFactory.getRoleRequestCreat());
        assertThat( role ).isNotNull();
        assertThat( role.getNome()).isEqualTo( "ROLE_USER" );
    }

    @Test
    @DisplayName("Deveria converter um RoleRequest em uma entity Role")
    void roleRequestToRole() {
        RoleFactory roleFactory = new RoleFactory();

        Role role = RoleMapper.INSTANCE.roleRequestToRole(roleFactory.getRoleRequest());
        assertThat( role ).isNotNull();
        assertThat( role.getId()).isEqualTo( 1L );
        assertThat( role.getNome()).isEqualTo( "ROLE_USER" );

    }

    @Test
    @DisplayName("Deveria converter um Role em uma entity RoleResponse")
    void roleToRoleResponse() {
        RoleFactory roleFactory = new RoleFactory();

        RoleResponse roleResponse = RoleMapper.INSTANCE.roleToRoleResponse(roleFactory.getRole());

        assertThat( roleResponse.id()).isEqualTo( 1L );
        assertThat( roleResponse.nome()).isEqualTo( "ROLE_USER" );
    }
}