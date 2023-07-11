package wl.open_house_api.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import wl.open_house_api.model.filme.request.FilmeRequest;
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
    public ResponseEntity<FilmeResponse> cadastrar(@RequestBody @Valid FilmeRequest filme,UriComponentsBuilder uriBuilder){
        FilmeResponse response = service.insert(filme);
        URI uri = uriBuilder.path("filmes/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }



}
