package wl.open_house_api.model.profile.entity;

import jakarta.persistence.*;

import java.io.Serializable;


@Table(name = "profiles")
@Entity(name = "Profile")
public class Profile implements Serializable {
    @EmbeddedId
    ProfileId profileId;


    public Profile(ProfileId profileId) {
        this.profileId = profileId;
    }

    public Profile() {
    }


    public ProfileId getProfileId() {
        return profileId;
    }

    public void setProfileId(ProfileId profileId) {
        this.profileId = profileId;
    }


    @Override
    public String toString() {
        return "Profile{" +
               "profileId=" + profileId +
               '}';
    }


}
