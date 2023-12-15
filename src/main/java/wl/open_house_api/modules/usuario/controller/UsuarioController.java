package wl.open_house_api.modules.usuario.controller;

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
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestCreatMaster;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestCreatUser;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestEditMaster;
import wl.open_house_api.modules.usuario.model.request.UsuarioRequestModifyStatus;
import wl.open_house_api.modules.usuario.model.response.UsuarioResponse;
import wl.open_house_api.modules.usuario.model.response.UsuarioResponseCrud;
import wl.open_house_api.modules.usuario.service.IUsuarioService;

import java.net.URI;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    final IUsuarioService service;

    public UsuarioController(IUsuarioService service) {
        this.service = service;
    }

    @PostMapping
    @SecurityRequirement(name = "bearer-key")
    @PreAuthorize("hasAnyRole('MASTER')")
    @Operation( summary = "Cadastra um usuário", description = "É necessário ter roles previamente cadastradas.", tags = { "Endpoints De Usuários" } )
    public ResponseEntity<UsuarioResponseCrud> cadastrar(@RequestBody @Valid UsuarioRequestCreatMaster user, UriComponentsBuilder uriBuilder) {
        UsuarioResponseCrud response = service.insert(user);
        URI uri = uriBuilder.path("usuarios/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PostMapping("/comum")
    @Operation( summary = "Cadastra um usuário comum", description = "Nesse cadastro é adicionado automaticamente o profile de ROLE_USER, a role deve está presente na base de dados", tags = { "Endpoints De Usuários" } )
    public ResponseEntity<UsuarioResponseCrud> cadastrarUserProfileUser(@RequestBody @Valid UsuarioRequestCreatUser user, UriComponentsBuilder uriBuilder) {
        UsuarioResponseCrud response = service.insertUserProfileUser(user);
        URI uri = uriBuilder.path("usuarios/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping
    @SecurityRequirement(name = "bearer-key")
    @PreAuthorize("hasAnyRole('MASTER', 'ADMIN', 'USER')")
    @Operation( summary = "Edita um usuário", description = "Altera somente as infomações basicas do usuários", tags = { "Endpoints De Usuários" } )
    public ResponseEntity<UsuarioResponseCrud> editar(@RequestBody @Valid UsuarioRequestEditMaster user) {
        UsuarioResponseCrud response = service.update(user);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/modificarStatus")
    @SecurityRequirement(name = "bearer-key")
    @PreAuthorize("hasAnyRole('MASTER')")
    @Operation( summary = "Edita o status usuário", description = "Altera o status do usuário, se o usuário estiver ativo é desativado caso contrario ele é ativado.", tags = { "Endpoints De Usuários" } )
    public ResponseEntity<HttpStatus> modificarStatus(@RequestBody @Valid UsuarioRequestModifyStatus user){
        service.modifyStatus(user.id());
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @SecurityRequirement(name = "bearer-key")
    @PreAuthorize("hasAnyRole('MASTER')")
    @Operation( summary = "Lista todos os usuários cadastrados", tags = { "Endpoints De Usuários" } )
    public ResponseEntity<Page<UsuarioResponse>> listarUsuarios(Pageable pageable){
        return ResponseEntity.ok(service.findUsers(pageable));
    }

    @GetMapping("/ativos")
    @SecurityRequirement(name = "bearer-key")
    @PreAuthorize("hasAnyRole('MASTER', 'ADMIN')")
    @Operation( summary = "Lista todos os usuários ativos cadastrados", tags = { "Endpoints De Usuários" } )
    public ResponseEntity<Page<UsuarioResponse>> listarUsuariosAtivos(Pageable pageable){
        return ResponseEntity.ok(service.findUsersStatusTrue(pageable));
    }


    @GetMapping("/{id}")
    @SecurityRequirement(name = "bearer-key")
    @PreAuthorize("hasAnyRole('MASTER', 'ADMIN')")
    @Operation( summary = "Detalha usuário cadastrado", tags = { "Endpoints De Usuários" } )
    public ResponseEntity<UsuarioResponse> detalharUsuario(@PathVariable Long id){
        return ResponseEntity.ok(service.findUser(id));
    }



    @DeleteMapping("/{id}")
    @SecurityRequirement(name = "bearer-key")
    @PreAuthorize("hasAnyRole('MASTER')")
    @Operation( summary = "Exclui um usuário cadastrado", description = "O usuário não pode ter profiles vinculados, para ser deletado", tags = { "Endpoints De Usuários" } )
    public ResponseEntity<HttpStatus> excluiruUsuario(@PathVariable Long id){
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
