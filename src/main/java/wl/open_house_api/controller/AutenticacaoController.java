package wl.open_house_api.controller;

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
import wl.open_house_api.model.autenticacao.response.TokenJwtResponse;
import wl.open_house_api.model.usuario.entity.Usuario;
import wl.open_house_api.service.TokenService;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    final AuthenticationManager manager;

    final TokenService tokenService;

    public AutenticacaoController(AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping()
    public ResponseEntity<TokenJwtResponse> efetuarLogin(@RequestBody @Valid UsuarioAtenticaoRequest userLogin) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userLogin.login(), userLogin.senha());
        Authentication authentication = manager.authenticate(token);
        String tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenJwtResponse(tokenJWT));
    }

}
