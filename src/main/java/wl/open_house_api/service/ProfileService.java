package wl.open_house_api.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wl.open_house_api.infra.exeptions.ValidacaoException;
import wl.open_house_api.model.profile.entity.Profile;
import wl.open_house_api.model.profile.mapper.ProfileMapper;
import wl.open_house_api.model.profile.request.ProfileRequestCreat;
import wl.open_house_api.model.profile.request.ProfileRequestEdit;
import wl.open_house_api.model.profile.response.ProfileResponse;
import wl.open_house_api.repository.ProfileRepository;
import wl.open_house_api.service.interfaces.ProfileServiceCrud;

import java.util.Optional;

@Service
public class ProfileService implements ProfileServiceCrud {

    final ProfileRepository repository;

    public ProfileService(ProfileRepository repository) {
        this.repository = repository;
    }


    @Override
    @Transactional
    public ProfileResponse insert(ProfileRequestCreat profileRequestCreat) {
        Profile profile = repository.save(ProfileMapper.INSTANCE.profileRequestCreatToProfile(profileRequestCreat));
        return ProfileMapper.INSTANCE.profileToProfileResponse(profile);
    }

    @Override
    @Transactional
    public ProfileResponse update(ProfileRequestEdit profileRequestEdit) {
        verificiarProfile(profileRequestEdit.id());
        Profile profile = repository.save(ProfileMapper.INSTANCE.profileRequestEditToProfile(profileRequestEdit));
        return ProfileMapper.INSTANCE.profileToProfileResponse(profile);
    }

    @Override
    @Transactional
    public ProfileResponse findProfile(Long id) {
        Profile profile = repository.getReferenceById(id);
        return ProfileMapper.INSTANCE.profileToProfileResponse(profile);
    }

    @Override
    public Page<ProfileResponse> findProfiles(Pageable pageable) {
        return repository.findAll(pageable).map(profile -> ProfileMapper.INSTANCE.profileToProfileResponse(profile));
    }

    @Override
    @Transactional
    public void deleteProfile(Long id) {
        repository.delete(verificiarProfile(id));
    }

    @Override
    public Boolean existProfile(Long id) {
        if(!repository.existsById(id)){
            throw new ValidacaoException("Profile não existe, verifique e tente e novamente!");
        }
        return true;
    }

    public Profile verificiarProfile(Long id){
        Optional<Profile> profile = repository.findById(id);
        if(!profile.isPresent()){
            throw new EntityNotFoundException();
        }
        return  profile.get();
    }
}
