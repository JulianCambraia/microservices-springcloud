package com.br.juliancambraia.hroauth.services;

import com.br.juliancambraia.hroauth.entities.User;
import com.br.juliancambraia.hroauth.feignclients.UserFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserFeign feign;

    public UserService(UserFeign feign) {
        this.feign = feign;
    }

    public User findByUserEmail(String email) {
        User user = feign.findByEmail(email).getBody();
        if (user == null) {
            LOGGER.error("Email not found: " + email);
            throw new IllegalArgumentException("Email not found: " + email);
        }
        LOGGER.info("Email found: " + email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = feign.findByEmail(username).getBody();
        if (user == null) {
            LOGGER.error("Email not found: " + username);
            throw new UsernameNotFoundException("Email not found: " + username);
        }
        LOGGER.info("Email found: " + username);
        return user;
    }
}
