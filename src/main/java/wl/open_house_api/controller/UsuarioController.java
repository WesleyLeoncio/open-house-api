package wl.open_house_api.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatMaster;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatUser;
import wl.open_house_api.model.usuario.request.UsuarioRequestEditMaster;
import wl.open_house_api.model.usuario.request.UsuarioRequestModifyStatus;
import wl.open_house_api.model.usuario.response.UsuarioResponse;
import wl.open_house_api.service.UsuarioService;

import java.net.URI;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastrar(@RequestBody @Valid UsuarioRequestCreatMaster user, UriComponentsBuilder uriBuilder) {
        UsuarioResponse response = service.insert(user);
        URI uri = uriBuilder.path("usuarios/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PostMapping("/roleUser")
    public ResponseEntity<UsuarioResponse> cadastrarUserProfileUser(@RequestBody @Valid UsuarioRequestCreatUser user, UriComponentsBuilder uriBuilder) {
        UsuarioResponse response = service.insertUserProfileUser(user);
        URI uri = uriBuilder.path("usuarios/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping
    public ResponseEntity<UsuarioResponse> editar(@RequestBody @Valid UsuarioRequestEditMaster user) {
        UsuarioResponse response = service.update(user);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/modificarStatus")
    public ResponseEntity<HttpStatus> modificarStatus(@RequestBody @Valid UsuarioRequestModifyStatus user){
        service.modifyStatus(user.id());
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<UsuarioResponse>> listarUsuarios(Pageable pageable){
        return ResponseEntity.ok(service.findUsers(pageable));
    }
    @GetMapping("/ativos")
    public ResponseEntity<Page<UsuarioResponse>> listarUsuariosAtivos(Pageable pageable){
        return ResponseEntity.ok(service.findUsersStatusTrue(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> detalharUsuario(@PathVariable Long id){
        return ResponseEntity.ok(service.findUser(id));
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> excluiruUsuario(Long id){
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
