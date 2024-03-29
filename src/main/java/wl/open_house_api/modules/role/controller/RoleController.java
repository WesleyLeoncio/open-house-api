package wl.open_house_api.modules.role.controller;

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
import wl.open_house_api.modules.role.model.request.RoleRequest;
import wl.open_house_api.modules.role.model.response.RoleResponse;
import wl.open_house_api.modules.role.service.IRoleService;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("roles")
@SecurityRequirement(name = "bearer-key")
public class RoleController {

    final IRoleService service;

    public RoleController(IRoleService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('MASTER')")
    @Operation( summary = "Adiciona uma nova role", description = "O nome da role deve seguir o padrão ROLE_NOME_DA_ROLE", tags = { "Endpoints De Roles" } )
    public ResponseEntity<RoleResponse> cadatrar(@RequestBody @Valid RoleRequest roleRequest, UriComponentsBuilder uriBuilder){
        RoleResponse response = service.insert(roleRequest);
        URI uri = uriBuilder.path("roles/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('MASTER')")
    @Operation( summary = "Edita uma role", description = "O nome da role deve seguir o padrão ROLE_NOME_DA_ROLE", tags = { "Endpoints De Roles" } )
    public ResponseEntity<RoleResponse> editar(@PathVariable UUID id, @RequestBody @Valid RoleRequest roleRequest){
        RoleResponse response = service.update(id, roleRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('MASTER')")
    @Operation( summary = "Lista todas as roles cadastradas", tags = { "Endpoints De Roles" } )
    public ResponseEntity<Page<RoleResponse>> listarRoles(Pageable pageable){
        return ResponseEntity.ok(service.findRoles(pageable));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('MASTER')")
    @Operation( summary = "Detalha uma role", tags = { "Endpoints De Roles" } )
    public ResponseEntity<RoleResponse> detalharRole(@PathVariable  UUID id){
        return ResponseEntity.ok(service.findRole(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('MASTER')")
    @Operation( summary = "Exclui uma role", description = "A role não pode pertencer a nenhum profile para ser excluida.", tags = { "Endpoints De Roles" } )
    public ResponseEntity<HttpStatus> excluirRole(@PathVariable UUID id){
        service.deleteRole(id);
        return ResponseEntity.noContent().build();
    }


}
