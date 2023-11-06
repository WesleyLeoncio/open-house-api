package wl.open_house_api.modules.role.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import wl.open_house_api.modules.role.factory.RoleFactory;
import wl.open_house_api.modules.role.model.request.RoleRequestCreat;
import wl.open_house_api.modules.role.model.response.RoleResponse;
import wl.open_house_api.modules.role.service.RoleService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class RoleControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    JacksonTester<RoleRequestCreat> roleRequestCreatJson;

    @Autowired
    JacksonTester<RoleResponse> roleResponseJson;

    @MockBean
    private RoleService roleService;

    private RoleFactory roleFactory;

    @BeforeEach
    public void beforeEach(){
        this.roleFactory = new RoleFactory();
    }

    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    @WithMockUser(authorities = "ROLE_MASTER")
    void cadatrarCenario1() throws Exception {
        MockHttpServletResponse response = mvc.perform(post("/roles"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 201 quando informacoes estao corretas")
    @WithMockUser(authorities = "ROLE_MASTER")
    void cadastrarCenario2() throws Exception {

        RoleResponse roleResponse = roleFactory.getRoleResponse();

        when(roleService.insert(any())).thenReturn(roleResponse);

        MockHttpServletResponse response = mvc.perform(
                post("/roles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(roleRequestCreatJson.write(
                                roleFactory.getRoleRequestCreat()
                        ).getJson())
        ).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        String jsonEsperado = roleResponseJson.write(roleResponse).getJson();
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }
}