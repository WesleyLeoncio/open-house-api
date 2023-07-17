package wl.open_house_api.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wl.open_house_api.model.profile.request.ProfileRequest;
import wl.open_house_api.model.profile.response.ProfileResponse;
import wl.open_house_api.service.ProfileService;



@RestController
@RequestMapping("profiles")
public class ProfileController {

    final ProfileService service;

    public ProfileController(ProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProfileResponse> adicionarProfile(@RequestBody @Valid ProfileRequest profileRequest){
        ProfileResponse response = service.adicionarProfile(profileRequest);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> removerProfile(@RequestBody @Valid ProfileRequest profileRequest){
        service.removerProfile(profileRequest);
        return ResponseEntity.noContent().build();
    }
}
