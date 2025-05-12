package com.security.app.controller;

import com.security.app.dto.ProfileDTO;
import com.security.app.service.ProfileService;
import com.security.app.service.impl.ProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileServiceImpl profileServiceImpl){
        this.profileService=profileServiceImpl;
    }

    @PostMapping
    public ResponseEntity<ProfileDTO> createProfile(@RequestBody ProfileDTO profileDTO){
        return ResponseEntity.ok(profileService.createProfile(profileDTO));
    }

}
