package com.security.app.service;

import com.security.app.model.Profile;
import com.security.app.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Profile profile = profileRepository.findByUsername(username)
                                                    .orElseThrow(()->new UsernameNotFoundException("Username not found Exception"));
        return new User(profile.getUsername(),profile.getPassword(), Collections.singleton(new SimpleGrantedAuthority("USER")));
    }
}
