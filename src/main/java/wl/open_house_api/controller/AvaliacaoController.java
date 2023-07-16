package wl.open_house_api.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wl.open_house_api.model.avaliacao.request.AvaliarFilmeRequest;
import wl.open_house_api.service.AvaliacaoService;

@RestController
@RequestMapping("avaliacoes")
public class AvaliacaoController {

    final AvaliacaoService service;

    public AvaliacaoController(AvaliacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> avaliarFilmes(@RequestBody @Valid AvaliarFilmeRequest avaliarFilme){
        service.avaliarFilme(avaliarFilme);
        return ResponseEntity.noContent().build();
    }
}
