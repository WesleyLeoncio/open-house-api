package wl.open_house_api.modules.avaliacao.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import wl.open_house_api.modules.avaliacao.model.request.AvaliarFilmeRequest;
import wl.open_house_api.modules.avaliacao.model.response.AvaliacaoDeFilmesNotaResponse;
import wl.open_house_api.modules.avaliacao.model.response.AvaliacaoDeFilmesResponse;
import wl.open_house_api.modules.avaliacao.service.IAvaliacaoService;
import wl.open_house_api.modules.usuario.model.entity.Usuario;

import java.util.UUID;


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
    @Operation(summary = "Avalia um filme", description = "É necessário ter filme e um usuario previamente cadastrados", tags = {"Endpoints De Avaliar Filmes"})
    public ResponseEntity<HttpStatus> avaliarFilmes(@RequestBody @Valid AvaliarFilmeRequest avaliarFilme,@AuthenticationPrincipal Usuario usuario) {
        service.avaliarFilme(avaliarFilme,usuario.getId());
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER')")
    @Operation(summary = "Lista todas as avaliações de filmes cadastrados", tags = {"Endpoints De Avaliar Filmes"})
    public ResponseEntity<Page<AvaliacaoDeFilmesResponse>> listarFilmesAvaliados(Pageable pageable) {
        return ResponseEntity.ok(service.listarFilmesAvaliados(pageable));
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @Operation(summary = "Lista todas as avaliações de filmes do usuário por userID", tags = {"Endpoints De Avaliar Filmes"})
    public ResponseEntity<Page<AvaliacaoDeFilmesResponse>> listarFilmesAvaliadosUser(Pageable pageable, @PathVariable UUID userId) {
        return ResponseEntity.ok(service.listarFilmesAvaliadosPorUser(pageable, userId));
    }

    @GetMapping("/user/")
    @PreAuthorize("hasAnyRole('USER')")
    @Operation(summary = "Lista todas as avaliações de filmes do usuário", tags = {"Endpoints De Avaliar Filmes"})
    public ResponseEntity<Page<AvaliacaoDeFilmesResponse>> listarFilmesAvaliadosUser(Pageable pageable, @AuthenticationPrincipal Usuario usuario) {
        return ResponseEntity.ok(service.listarFilmesAvaliadosPorUser(pageable, usuario.getId()));
    }

    @GetMapping("/avaliacao/{filmeId}")
    @PreAuthorize("hasAnyRole('USER')")
    @Operation(summary = "Lista a avaliação do filme com base no id do filme", tags = {"Endpoints De Avaliar Filmes"})
    public ResponseEntity<AvaliacaoDeFilmesResponse> listarAvaliacaoPorFilmeIdUserId(@PathVariable UUID filmeId, @AuthenticationPrincipal Usuario usuario) {
        return ResponseEntity.ok(service.listaAvaliacaoPorFilmeIdUserId(filmeId, usuario.getId()));
    }

    @GetMapping("/avaliacao/{filmeId}/{usuarioId}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @Operation(summary = "Lista a avaliação do filme com base no usuário e no filme", tags = {"Endpoints De Avaliar Filmes"})
    public ResponseEntity<AvaliacaoDeFilmesResponse> listarAvaliacaoPorFilmeIdUserId(@PathVariable UUID filmeId, @PathVariable UUID usuarioId) {
        return ResponseEntity.ok(service.listaAvaliacaoPorFilmeIdUserId(filmeId, usuarioId));
    }

    @GetMapping("/nota/{filmeId}")
    @PreAuthorize("hasAnyRole('USER')")
    @Operation(summary = "Lista a nota do filme com base no id do filme", tags = {"Endpoints De Avaliar Filmes"})
    public ResponseEntity<AvaliacaoDeFilmesNotaResponse> notaAvaliacaoFilme(@PathVariable UUID filmeId, @AuthenticationPrincipal Usuario usuario) {
        return ResponseEntity.ok(service.notaFilme(filmeId, usuario.getId()));
    }
}
