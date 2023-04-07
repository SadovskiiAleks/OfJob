package com.example.goodJobAleks.secutity;

import com.example.goodJobAleks.models.User;
import com.example.goodJobAleks.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImp")
public class UserDetailsServiceImp implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("User doesn't exists"));
        return  SecurityUser.fromUser(user);
    }
}
