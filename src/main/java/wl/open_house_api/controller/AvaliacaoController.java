package wl.open_house_api.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wl.open_house_api.model.avaliacao.request.AvaliarFilmeRequest;
import wl.open_house_api.model.avaliacao.response.AvaliacaoDeFilmesResponse;
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

    @GetMapping
    public ResponseEntity<Page<AvaliacaoDeFilmesResponse>> listarFilmesAvaliados(Pageable pageable){
        return ResponseEntity.ok(service.listarFilmesAvaliados(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Page<AvaliacaoDeFilmesResponse>> listarFilmesAvaliadosUser(Pageable pageable, @PathVariable Long id){
        return ResponseEntity.ok(service.listarFilmesAvaliadosPorUser(pageable,id));
    }


}
