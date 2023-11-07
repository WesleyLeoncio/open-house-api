package wl.open_house_api.modules.categoria.controller;

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
import wl.open_house_api.modules.categoria.factory.CategoriaFactory;
import wl.open_house_api.modules.categoria.model.request.CategoriaRequestCreat;
import wl.open_house_api.modules.categoria.model.response.CategoriaResponseId;
import wl.open_house_api.modules.categoria.service.CategoriaService;
import wl.open_house_api.modules.role.model.response.RoleResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class CategoriaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    JacksonTester<CategoriaRequestCreat> categoriaRequestCreatJson;

    @Autowired
    JacksonTester<CategoriaResponseId> categoriaResponseIdJson;

    @MockBean
    private CategoriaService categoriaService;

    private CategoriaFactory categoriaFactory;

    @BeforeEach
    public void beforeEach(){
        this.categoriaFactory = new CategoriaFactory();
    }

    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    @WithMockUser(authorities = "ROLE_ADMIN")
    void cadatrarCenario1() throws Exception {
        MockHttpServletResponse response = mvc.perform(post("/categorias"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 201 quando informacoes estao corretas")
    @WithMockUser(authorities = "ROLE_ADMIN")
    void cadastrarCenario2() throws Exception {

        CategoriaResponseId categoriaResponseId = categoriaFactory.getCategoriaResponseId();

        when(categoriaService.insert(any())).thenReturn(categoriaResponseId);

        MockHttpServletResponse response = mvc.perform(
                post("/categorias")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(categoriaRequestCreatJson.write(
                                categoriaFactory.getCategoriaRequestCreat()
                        ).getJson())
        ).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        String jsonEsperado = categoriaResponseIdJson.write(categoriaResponseId).getJson();
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }


}