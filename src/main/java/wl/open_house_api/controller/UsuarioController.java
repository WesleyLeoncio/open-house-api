package wl.open_house_api.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import wl.open_house_api.model.usuario.entity.Usuario;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatMaster;
import wl.open_house_api.model.usuario.request.UsuarioRequestCreatUser;
import wl.open_house_api.model.usuario.request.UsuarioRequestEditMaster;
import wl.open_house_api.model.usuario.request.UsuarioRequestModifyStatus;
import wl.open_house_api.model.usuario.response.UsuarioResponse;
import wl.open_house_api.repository.UsuarioRepository;
import wl.open_house_api.service.UsuarioService;
import java.net.URI;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService service;

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioService service, UsuarioRepository repository) {
        this.service = service;
        this.repository = repository;
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

    //TODO MODIFICADO
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> detalharUsuario(@PathVariable Long id){
        Usuario usuario = repository.findById(id).get();
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> excluiruUsuario(Long id){
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
