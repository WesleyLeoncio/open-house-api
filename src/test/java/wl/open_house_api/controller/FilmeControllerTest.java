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
import wl.open_house_api.modules.filme.factory.FilmeFactory;
import wl.open_house_api.modules.filme.model.request.FilmeRequestCreat;
import wl.open_house_api.modules.filme.model.response.FilmeResponse;
import wl.open_house_api.modules.filme.model.response.FilmeResponseCreat;
import wl.open_house_api.modules.filme.service.FilmeService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class FilmeControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    private JacksonTester<FilmeRequestCreat> filmeRequestCreatJson;

    @Autowired
    private JacksonTester<FilmeResponseCreat> filmeResponseCreatJson;

    @MockBean
    private FilmeService filmeService;

    private FilmeFactory filmeFactory;

    @BeforeEach
    public void beforeEach(){
        this.filmeFactory = new FilmeFactory();
    }

    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    @WithMockUser(authorities = "ROLE_ADMIN")
    void cadastrarCenario1() throws Exception {
        MockHttpServletResponse response = mvc.perform(post("/filmes"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

   @Test
    @DisplayName("Deveria devolver codigo http 201 quando informacoes estao corretas")
    @WithMockUser(authorities = "ROLE_ADMIN")
    void cadastrarCenario2() throws Exception {

       FilmeResponseCreat filmeResponseCreat = filmeFactory.getFilmeResponseCreat();

        when(filmeService.insert(any())).thenReturn(filmeResponseCreat);

        MockHttpServletResponse response = mvc.perform(
                post("/filmes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(filmeRequestCreatJson.write(
                                filmeFactory.getFilmeRequestCreat()
                        ).getJson())
        ).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        String jsonEsperado = filmeResponseCreatJson.write(filmeResponseCreat).getJson();
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }
}