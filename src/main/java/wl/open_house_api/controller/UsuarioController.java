package wl.open_house_api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatMaster;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatUser;
import wl.open_house_api.model.usuario.request.UsuarioRequestEditMaster;
import wl.open_house_api.model.usuario.request.UsuarioRequestModifyStatus;
import wl.open_house_api.model.usuario.response.UsuarioResponse;
import wl.open_house_api.model.usuario.response.UsuarioResponseCrud;
import wl.open_house_api.service.UsuarioService;
import java.net.URI;

@RestController
@RequestMapping("usuarios")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('MASTER')")
    public ResponseEntity<UsuarioResponseCrud> cadastrar(@RequestBody @Valid UsuarioRequestCreatMaster user, UriComponentsBuilder uriBuilder) {
        UsuarioResponseCrud response = service.insert(user);
        URI uri = uriBuilder.path("usuarios/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PostMapping("/comum")
    public ResponseEntity<UsuarioResponseCrud> cadastrarUserProfileUser(@RequestBody @Valid UsuarioRequestCreatUser user, UriComponentsBuilder uriBuilder) {
        UsuarioResponseCrud response = service.insertUserProfileUser(user);
        URI uri = uriBuilder.path("usuarios/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('MASTER')")
    public ResponseEntity<UsuarioResponseCrud> editar(@RequestBody @Valid UsuarioRequestEditMaster user) {
        UsuarioResponseCrud response = service.update(user);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/modificarStatus")
    @PreAuthorize("hasAnyRole('MASTER')")
    public ResponseEntity<HttpStatus> modificarStatus(@RequestBody @Valid UsuarioRequestModifyStatus user){
        service.modifyStatus(user.id());
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('MASTER')")
    public ResponseEntity<Page<UsuarioResponse>> listarUsuarios(Pageable pageable){
        return ResponseEntity.ok(service.findUsers(pageable));
    }
    @GetMapping("/ativos")
    @PreAuthorize("hasAnyRole('MASTER', 'ADMIN')")
    public ResponseEntity<Page<UsuarioResponse>> listarUsuariosAtivos(Pageable pageable){
        return ResponseEntity.ok(service.findUsersStatusTrue(pageable));
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('MASTER', 'ADMIN')")
    public ResponseEntity<UsuarioResponse> detalharUsuario(@PathVariable Long id){
        return ResponseEntity.ok(service.findUser(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('MASTER')")
    public ResponseEntity<HttpStatus> excluiruUsuario(@PathVariable Long id){
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
