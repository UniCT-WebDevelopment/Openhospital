package com.openhospital.ecommerce.security;

import com.openhospital.ecommerce.beans.externalservices.userservice.get.GetUserInput;
import com.openhospital.ecommerce.beans.externalservices.userservice.get.GetUserOutput;
import com.openhospital.ecommerce.beans.user.UserProfile;
import com.openhospital.ecommerce.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        GetUserInput getUserInput = new GetUserInput();
        getUserInput.setEmail(email);

        GetUserOutput getUserOutput = userService.getUser(getUserInput);

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(getUserOutput.getUser().getUserType()));

        UserProfile user = new UserProfile(getUserOutput.getUser(), grantedAuthorities);

        return user;
    }

}
