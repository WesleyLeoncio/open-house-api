package wl.open_house_api.modules.categoria_filme.controller;

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
import wl.open_house_api.modules.categoria_filme.factory.CategoriaFilmeFactory;
import wl.open_house_api.modules.categoria_filme.model.request.CategoriaFilmeRequest;
import wl.open_house_api.modules.categoria_filme.model.response.CategoriaFilmeResponse;
import wl.open_house_api.modules.categoria_filme.service.CategoriaFilmeService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class CategoriaFilmeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<CategoriaFilmeRequest> categoriaFilmeRequestJson;

    @Autowired
    private JacksonTester<CategoriaFilmeResponse> categoriaFilmeResponseJson;

    @MockBean
    private CategoriaFilmeService categoriaFilmeService;

    private CategoriaFilmeFactory categoriaFilmeFactory;

    @BeforeEach
    public void beforeEach(){
        this.categoriaFilmeFactory = new CategoriaFilmeFactory();
    }


    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    @WithMockUser(authorities = "ROLE_ADMIN")
    void adicionarCategoriaFilmeCenario1() throws Exception {
        MockHttpServletResponse response = mvc.perform(post("/categoriaFilme"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando informacoes estao corretas")
    @WithMockUser(authorities = "ROLE_ADMIN")
    void adicionarCategoriaFilmeCenario2() throws Exception {

        CategoriaFilmeResponse categoriaFilmeResponse =
                categoriaFilmeFactory.getCategoriaFilmeResponse();

        when(categoriaFilmeService.adicionarCategoriaFilme(any())).thenReturn(categoriaFilmeResponse);

        MockHttpServletResponse response = mvc.perform(
                post("/categoriaFilme")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(categoriaFilmeRequestJson.write(
                                categoriaFilmeFactory.getCategoriaFilmeRequest()
                        ).getJson())
        ).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        String jsonEsperado = categoriaFilmeResponseJson.write(categoriaFilmeResponse).getJson();
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }
}