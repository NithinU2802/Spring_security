package com.security.app.service.impl;

import com.security.app.dto.ProfileDTO;
import com.security.app.model.Profile;
import com.security.app.repository.ProfileRepository;
import com.security.app.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    public ProfileDTO createProfile(ProfileDTO profileDTO){
        Profile profile = new Profile();
        profile.setEmail(profileDTO.getEmail());
        profile.setUsername(profileDTO.getUsername());
        profile.setPassword(profileDTO.getPassword());
        Profile savedProfile = profileRepository.save(profile);
        ProfileDTO updatedProfileDTO = new ProfileDTO();
        updatedProfileDTO.setUsername(savedProfile.getUsername());
        updatedProfileDTO.setEmail(savedProfile.getEmail());
        updatedProfileDTO.setPassword(savedProfile.getPassword());
        return updatedProfileDTO;
    }

}
