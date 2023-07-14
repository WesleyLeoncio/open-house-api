package wl.open_house_api.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import wl.open_house_api.model.filme.request.FilmeRequestCreat;
import wl.open_house_api.model.filme.request.FilmeRequestEdit;
import wl.open_house_api.model.filme.response.FilmeListResponse;
import wl.open_house_api.model.filme.response.FilmeResponse;
import wl.open_house_api.service.FilmeService;

import java.net.URI;

@RestController
@RequestMapping("filmes")
public class FilmeController {

    private final FilmeService service;


    public FilmeController(FilmeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FilmeResponse> cadastrar(@RequestBody @Valid FilmeRequestCreat filme, UriComponentsBuilder uriBuilder) {
        FilmeResponse response = service.insert(filme);
        URI uri = uriBuilder.path("filmes/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping
    public ResponseEntity<FilmeResponse> editar(@RequestBody @Valid FilmeRequestEdit filme) {
        FilmeResponse response = service.update(filme);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<FilmeListResponse>> listarFilmes(@PageableDefault(sort = {"dataLancamento"},
            direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(service.findMovies(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeResponse> detalharFilme(@PathVariable Long id) {
        return ResponseEntity.ok(service.findMovie(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> excluirFilme(@PathVariable Long id) {
        service.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }


}
