package wl.open_house_api.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wl.open_house_api.model.autenticacao.request.UsuarioAtenticaoRequest;
import wl.open_house_api.model.autenticacao.response.UsuarioTokenResponse;
import wl.open_house_api.model.usuario.entity.Usuario;
import wl.open_house_api.service.interfaces.ITokenService;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    final AuthenticationManager manager;

    final ITokenService tokenService;

    public AutenticacaoController(AuthenticationManager manager, ITokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping()
    @Operation( summary = "Realiza o login", description = "É necessário ter usuários previamente cadastrados.", tags = { "Endpoint De Login" } )
    public ResponseEntity<UsuarioTokenResponse> efetuarLogin(@RequestBody @Valid UsuarioAtenticaoRequest userLogin) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userLogin.login(), userLogin.senha());
        Authentication authentication = manager.authenticate(token);
        String tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new UsuarioTokenResponse(userLogin.login(),tokenJWT));
    }

}
