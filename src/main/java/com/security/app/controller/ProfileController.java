package com.security.app.controller;

import com.security.app.dto.ProfileDTO;
import com.security.app.service.ProfileService;
import com.security.app.service.impl.ProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    private final PasswordEncoder passwordEncoder;

    public ProfileController(ProfileServiceImpl profileServiceImpl, PasswordEncoder passwordEncoder){
        this.profileService=profileServiceImpl;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public ResponseEntity<ProfileDTO> createProfile(@RequestBody ProfileDTO profileDTO){
        profileDTO.setPassword(passwordEncoder.encode(profileDTO.getPassword()));
        return ResponseEntity.ok(profileService.createProfile(profileDTO));
    }

}
