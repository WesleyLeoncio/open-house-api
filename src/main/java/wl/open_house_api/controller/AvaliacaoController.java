package wl.open_house_api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import wl.open_house_api.model.avaliacao.request.AvaliarFilmeRequest;
import wl.open_house_api.model.avaliacao.response.AvaliacaoDeFilmesResponse;
import wl.open_house_api.service.AvaliacaoService;



@RestController
@RequestMapping("avaliacoes")
@SecurityRequirement(name = "bearer-key")
public class AvaliacaoController {

    final AvaliacaoService service;


    public AvaliacaoController(AvaliacaoService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('MASTER','ADMIN','USER')")
    public ResponseEntity<HttpStatus> avaliarFilmes(@RequestBody @Valid AvaliarFilmeRequest avaliarFilme){
        service.avaliarFilme(avaliarFilme);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('MASTER','ADMIN','USER')")
    public ResponseEntity<Page<AvaliacaoDeFilmesResponse>> listarFilmesAvaliados(Pageable pageable){
        return ResponseEntity.ok(service.listarFilmesAvaliados(pageable));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('MASTER','ADMIN','USER')")
    public ResponseEntity<Page<AvaliacaoDeFilmesResponse>> listarFilmesAvaliadosUser(Pageable pageable, @PathVariable Long id){
        return ResponseEntity.ok(service.listarFilmesAvaliadosPorUser(pageable,id));
    }


}
