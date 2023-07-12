package wl.open_house_api.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import wl.open_house_api.model.profile.request.ProfileRequestCreat;
import wl.open_house_api.model.profile.request.ProfileRequestEdit;
import wl.open_house_api.model.profile.response.ProfileResponse;
import wl.open_house_api.service.ProfileService;

import java.net.URI;

@RestController
@RequestMapping("profiles")
public class ProfileController {
    //TODO TRATAR AS EXCEPTIONS
    final private ProfileService service;

    public ProfileController(ProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProfileResponse> cadatrar(@RequestBody @Valid ProfileRequestCreat profileRequestCreat, UriComponentsBuilder uriBuilder){
        ProfileResponse response = service.insert(profileRequestCreat);
        URI uri = uriBuilder.path("profiles/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileResponse> editar(@RequestBody @Valid ProfileRequestEdit profileRequestEdit){
        ProfileResponse response = service.update(profileRequestEdit);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<ProfileResponse>> listarProfiles(Pageable pageable){
        return ResponseEntity.ok(service.findProfiles(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponse> detalharProfile(Long id){
        return ResponseEntity.ok(service.findProfile(id));
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> excluirProfile(Long id){
        service.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }

}
