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
import wl.open_house_api.model.avaliacao.factory.AvaliacaoFilmeFactory;
import wl.open_house_api.model.avaliacao.request.AvaliarFilmeRequest;
import wl.open_house_api.service.AvaliacaoService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class AvaliacaoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<AvaliarFilmeRequest> avaliarFilmeRequestJson;

    @MockBean
    private AvaliacaoService avaliacaoService;

    private AvaliacaoFilmeFactory avaliacaoFilmeFactory;

    @BeforeEach
    public void beforeEach(){
        this.avaliacaoFilmeFactory = new AvaliacaoFilmeFactory();
    }

    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    @WithMockUser(authorities = "ROLE_USER")
    void avaliarFilmesCenario1() throws Exception {
        MockHttpServletResponse response = mvc.perform(post("/avaliacoes"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }


    @Test
    @DisplayName("Deveria devolver codigo http 204 quando informacoes estao corretas")
    @WithMockUser(authorities = "ROLE_USER")
    void avaliarFilmesCenario2() throws Exception {
        MockHttpServletResponse response = mvc.perform(
                post("/avaliacoes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(avaliarFilmeRequestJson.write(
                                avaliacaoFilmeFactory.getAvaliarFilmeRequest()
                        ).getJson())
        ).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());

    }
}