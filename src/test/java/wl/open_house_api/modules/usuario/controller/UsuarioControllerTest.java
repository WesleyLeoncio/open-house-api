package wl.open_house_api.modules.usuario.controller;

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
import wl.open_house_api.modules.usuario.factory.UsuarioFactory;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestCreatMaster;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestCreatUser;
import wl.open_house_api.modules.usuario.model.response.UsuarioResponse;
import wl.open_house_api.modules.usuario.service.UsuarioService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class UsuarioControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<UsuarioRequestCreatMaster> usuarioRequestCreatMasterJson;

    @Autowired
    private JacksonTester<UsuarioRequestCreatUser> usuarioRequestCreatUserJson;

    @Autowired
    private JacksonTester<UsuarioResponse> usuarioResponseJson;

    @MockBean
    private UsuarioService usuarioService;

    private UsuarioFactory usuarioFactory;

    @BeforeEach
    public void beforeEach(){
        this.usuarioFactory = new UsuarioFactory();
    }


    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    @WithMockUser(authorities = "ROLE_MASTER")
    void cadastrarCenario1() throws Exception {
        MockHttpServletResponse response = mvc.perform(post("/usuarios"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 201 quando informacoes estao corretas")
    @WithMockUser(authorities = "ROLE_MASTER")
    void cadastrarCenario2() throws Exception {

        UsuarioResponse usuarioResponse = usuarioFactory.getUsuarioResponse();

        when(usuarioService.insert(any())).thenReturn(usuarioResponse);

        MockHttpServletResponse response = mvc.perform(
                post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(usuarioRequestCreatMasterJson.write(
                                usuarioFactory.getUsuarioRequestCreatMaster()
                        ).getJson())
        ).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        String jsonEsperado = usuarioResponseJson.write(usuarioResponse).getJson();
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }


    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    void cadastrarUserProfileUser() throws Exception {
        MockHttpServletResponse response = mvc.perform(post("/usuarios/comum"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 201 quando informacoes estao corretas")
    void cadastrarUserProfileUserCenario2() throws Exception {

        UsuarioResponse usuarioResponse = usuarioFactory.getUsuarioResponse();

        when(usuarioService.insertUserProfileUser(any())).thenReturn(usuarioResponse);

        MockHttpServletResponse response = mvc.perform(
                post("/usuarios/comum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(usuarioRequestCreatUserJson.write(
                                usuarioFactory.getUsuarioRequestCreatUser()
                        ).getJson())
        ).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        String jsonEsperado = usuarioResponseJson.write(usuarioResponse).getJson();
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }
}