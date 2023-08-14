package wl.open_house_api.controller;

import io.swagger.v3.oas.annotations.Operation;
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
import wl.open_house_api.service.interfaces.IAvaliacaoService;


@RestController
@RequestMapping("avaliacoes")
@SecurityRequirement(name = "bearer-key")
public class AvaliacaoController {

    final IAvaliacaoService service;


    public AvaliacaoController(IAvaliacaoService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('USER')")
    @Operation( summary = "Avalia um filme", description = "É necessário ter filme e um usuario previamente cadastrados", tags = { "Endpoints De Avaliar Filmes" } )
    public ResponseEntity<HttpStatus> avaliarFilmes(@RequestBody @Valid AvaliarFilmeRequest avaliarFilme){
        service.avaliarFilme(avaliarFilme);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER')")
    @Operation( summary = "Lista todas as avaliações de filmes cadastrados", tags = { "Endpoints De Avaliar Filmes" } )
    public ResponseEntity<Page<AvaliacaoDeFilmesResponse>> listarFilmesAvaliados(Pageable pageable){
        return ResponseEntity.ok(service.listarFilmesAvaliados(pageable));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER')")
    @Operation( summary = "Lista todas as avaliações de filmes cadastrados do usuário", tags = { "Endpoints De Avaliar Filmes" } )
    public ResponseEntity<Page<AvaliacaoDeFilmesResponse>> listarFilmesAvaliadosUser(Pageable pageable, @PathVariable Long id){
        return ResponseEntity.ok(service.listarFilmesAvaliadosPorUser(pageable,id));
    }


}
