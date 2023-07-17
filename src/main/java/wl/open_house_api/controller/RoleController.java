package wl.open_house_api.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import wl.open_house_api.model.role.request.RoleRequest;
import wl.open_house_api.model.role.request.RoleRequestCreat;
import wl.open_house_api.model.role.response.RoleResponse;
import wl.open_house_api.repository.ProfileRepository;
import wl.open_house_api.service.RoleService;

import java.net.URI;

@RestController
@RequestMapping("roles")
public class RoleController {

    final RoleService service;

    final ProfileRepository repository;

    public RoleController(RoleService service, ProfileRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<RoleResponse> cadatrar(@RequestBody @Valid RoleRequestCreat roleRequestCreat, UriComponentsBuilder uriBuilder){
        RoleResponse response = service.insert(roleRequestCreat);
        URI uri = uriBuilder.path("profiles/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping
    public ResponseEntity<RoleResponse> editar(@RequestBody @Valid RoleRequest roleRequest){
        RoleResponse response = service.update(roleRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<RoleResponse>> listarRoles(Pageable pageable){
        return ResponseEntity.ok(service.findRoles(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> detalharRole(@PathVariable  Long id){
        return ResponseEntity.ok(service.findRole(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> excluirRole(@PathVariable Long id){
        service.deleteRole(id);
        return ResponseEntity.noContent().build();
    }


}
