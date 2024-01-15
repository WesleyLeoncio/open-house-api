package wl.open_house_api.modules.filme.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import wl.open_house_api.modules.filme.model.request.FilmeRequestCreat;
import wl.open_house_api.modules.filme.model.request.FilmeRequestEdit;
import wl.open_house_api.modules.filme.model.response.FilmeResponse;
import wl.open_house_api.modules.filme.service.IFilmeService;

import java.net.URI;

@RestController
@RequestMapping("filmes")
@SecurityRequirement(name = "bearer-key")
public class FilmeController {

    private final IFilmeService service;

    public FilmeController(IFilmeService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    @Operation( summary = "Cadastra um filme", tags = { "Endpoints De Filmes" } )
    public ResponseEntity<FilmeResponse> cadastrar(@RequestBody @Valid FilmeRequestCreat filme, UriComponentsBuilder uriBuilder) {
        FilmeResponse response = service.insert(filme);
        URI uri = uriBuilder.path("filmes/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @Operation( summary = "Edita um filme", tags = { "Endpoints De Filmes" } )
    public ResponseEntity<FilmeResponse> editar(@PathVariable Long id, @RequestBody @Valid FilmeRequestEdit filme) {
        FilmeResponse response = service.update(id, filme);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER')")
    @Operation( summary = "Lista todos os filmes cadastrados", tags = { "Endpoints De Filmes" } )
    public ResponseEntity<Page<FilmeResponse>> listarFilmes(@PageableDefault(sort = {"dataLancamento"},
            direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(service.findMovies(pageable));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER')")
    @Operation( summary = "Detalhar um filme", tags = { "Endpoints De Filmes" } )
    public ResponseEntity<FilmeResponse> detalharFilme(@PathVariable Long id) {
        return ResponseEntity.ok(service.findMovie(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @Operation( summary = "Exclui um filme", tags = { "Endpoints De Filmes" } )
    public ResponseEntity<HttpStatus> excluirFilme(@PathVariable Long id) {
        service.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }


}
