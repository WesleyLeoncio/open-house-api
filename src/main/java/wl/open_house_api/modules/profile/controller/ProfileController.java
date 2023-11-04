package wl.open_house_api.modules.profile.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import wl.open_house_api.modules.profile.model.request.ProfileRequest;
import wl.open_house_api.modules.profile.model.response.ProfileResponse;
import wl.open_house_api.modules.profile.service.IProfileService;

@RestController
@RequestMapping("profiles")
@SecurityRequirement(name = "bearer-key")
public class ProfileController {

    final IProfileService service;

    public ProfileController(IProfileService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('MASTER')")
    @Operation( summary = "Adiciona um profile para um usuario", description = "É necessário ter usuários e roles previamente cadastrados.", tags = { "Endpoints De Profiles" } )
    public ResponseEntity<ProfileResponse> adicionarProfile(@RequestBody @Valid ProfileRequest profileRequest){
        ProfileResponse response = service.adicionarProfile(profileRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    @PreAuthorize("hasAnyRole('MASTER')")
    @Operation( summary = "Remove um profile de um usuario", description = "É necessário ter usuários e roles previamente cadastrados.", tags = { "Endpoints De Profiles" } )
    public ResponseEntity<HttpStatus> removerProfile(@RequestBody @Valid ProfileRequest profileRequest){
        service.removerProfile(profileRequest);
        return ResponseEntity.noContent().build();
    }
}
