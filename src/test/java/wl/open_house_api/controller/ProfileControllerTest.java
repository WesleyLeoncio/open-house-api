package wl.open_house_api.controller;

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
import wl.open_house_api.model.profile.factory.ProfileFactory;
import wl.open_house_api.model.profile.request.ProfileRequest;
import wl.open_house_api.model.profile.response.ProfileResponse;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatMaster;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatUser;
import wl.open_house_api.model.usuario.response.UsuarioResponseCrud;
import wl.open_house_api.service.ProfileService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ProfileControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<ProfileRequest> profileRequestJson;

    @Autowired
    private JacksonTester<ProfileResponse> profileResponseJson;

    @MockBean
    private ProfileService profileService;

    private ProfileFactory profileFactory;

    @BeforeEach
    public void beforeEach(){
        this.profileFactory = new ProfileFactory();
    }

    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    @WithMockUser(authorities = "ROLE_MASTER")
    void adicionarProfileCenario1() throws Exception {
        MockHttpServletResponse response = mvc.perform(post("/profiles"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando informacoes estao corretas")
    @WithMockUser(authorities = "ROLE_MASTER")
    void adicionarProfileCenario2() throws Exception {

        ProfileResponse profileResponse = profileFactory.getProfileResponse();

        when(profileService.adicionarProfile(any())).thenReturn(profileResponse);

        MockHttpServletResponse response = mvc.perform(
                post("/profiles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(profileRequestJson.write(
                                profileFactory.getProfileRequest()
                        ).getJson())
        ).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        String jsonEsperado = profileResponseJson.write(profileResponse).getJson();
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }
}