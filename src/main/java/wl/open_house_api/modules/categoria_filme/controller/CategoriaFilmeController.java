package wl.open_house_api.modules.categoria_filme.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import wl.open_house_api.modules.categoria_filme.model.request.CategoriaFilmeRequest;
import wl.open_house_api.modules.categoria_filme.model.response.CategoriaFilmeResponse;
import wl.open_house_api.modules.categoria_filme.service.ICategoriaFilmeService;

@RestController
@RequestMapping("categoriaFilme")
@SecurityRequirement(name = "bearer-key")
public class CategoriaFilmeController {

    private final ICategoriaFilmeService service;

    public CategoriaFilmeController(ICategoriaFilmeService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    @Operation( summary = "Adiciona uma CategoriaFilme para um Filme", description = "É necessário ter filme e categoria previamente cadastrados.", tags = { "Endpoints De Categorias/Filmes" } )
    public ResponseEntity<CategoriaFilmeResponse> cadastrarCategoriaFilme(@RequestBody @Valid CategoriaFilmeRequest categoriaFilmeRequest){
        CategoriaFilmeResponse response = service.adicionarCategoriaFilme(categoriaFilmeRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    @Operation( summary = "Remove um profile de um usuario", description = "É necessário ter filme e categoria previamente cadastrados.", tags = { "Endpoints De Categorias/Filmes" } )
    public ResponseEntity<HttpStatus> removerCategoriaFilme(@RequestBody @Valid CategoriaFilmeRequest categoriaFilmeRequest){
        service.removerCategoriaFilme(categoriaFilmeRequest);
        return ResponseEntity.noContent().build();
    }
}
