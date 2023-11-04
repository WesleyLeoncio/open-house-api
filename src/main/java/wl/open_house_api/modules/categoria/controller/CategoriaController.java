package wl.open_house_api.modules.categoria.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import wl.open_house_api.modules.categoria.model.request.CategoriaRequest;
import wl.open_house_api.modules.categoria.model.request.CategoriaRequestCreat;
import wl.open_house_api.modules.categoria.model.response.CategoriaResponseId;
import wl.open_house_api.modules.categoria.service.ICategoriaService;

import java.net.URI;

@RestController
@RequestMapping("categorias")
@SecurityRequirement(name = "bearer-key")
public class CategoriaController {

    private final ICategoriaService service;

    public CategoriaController(ICategoriaService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    @Operation( summary = "Adiciona uma nova categoria", description = "As Categorias devem ser em caixa alta", tags = { "Endpoints De Categorias" } )
    public ResponseEntity<CategoriaResponseId> cadatrar(@RequestBody @Valid CategoriaRequestCreat categoriaRequestCreat, UriComponentsBuilder uriBuilder){
        CategoriaResponseId response = service.insert(categoriaRequestCreat);
        URI uri = uriBuilder.path("categorias/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    @Operation( summary = "Editar uma categoria", description = "As Categorias devem ser em caixa alta", tags = { "Endpoints De Categorias" } )
    public ResponseEntity<CategoriaResponseId> editar(@RequestBody @Valid CategoriaRequest categoriaRequest){
        CategoriaResponseId response = service.update(categoriaRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    @Operation( summary = "Lista todos as categorias cadastrados", tags = { "Endpoints De Categorias" } )
    public ResponseEntity<Page<CategoriaResponseId>> listarFilmes(Pageable pageable) {
        return ResponseEntity.ok(service.findCategorias(pageable));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @Operation( summary = "Detalhar uma categoria", tags = { "Endpoints De Categorias" } )
    public ResponseEntity<CategoriaResponseId> detalharFilme(@PathVariable  Long id) {
        return ResponseEntity.ok(service.findCategoria(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    @Operation( summary = "Exclui uma categoria", description = "A Categoria não pode pertencer a nenhum filme para ser excluida.", tags = { "Endpoints De Categorias" } )
    public ResponseEntity<HttpStatus> excluirFilme(@PathVariable  Long id) {
        service.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }

}
