package com.nodo.retobackend.service.impl;

import com.github.benmanes.caffeine.cache.Cache;
import com.nodo.retobackend.model.User;
import com.nodo.retobackend.repository.IUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private Cache<String, UserDetails> userDetailsCache;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails cachedUser = userDetailsCache.getIfPresent(username);
        if (cachedUser != null) {
            log.info("[UserDetailsService] Se encuentra usuario en caché");
            return cachedUser;
        }

        User user = userRepository.findByMail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(user.getMail())
                .password(user.getPassword())
                .build();

        userDetailsCache.put(username, userDetails);

        return userDetails;
    }
}
