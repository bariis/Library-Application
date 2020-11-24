package com.baris.ertas.LibraryApplicaton.service;

import com.baris.ertas.LibraryApplicaton.util.AuthenticationProvider;
import com.baris.ertas.LibraryApplicaton.model.Role;
import com.baris.ertas.LibraryApplicaton.model.User;
import com.baris.ertas.LibraryApplicaton.repository.RoleRepository;
import com.baris.ertas.LibraryApplicaton.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    AuthenticationProvider authenticationProvider;

    public BCryptPasswordEncoder encoder = bCryptPasswordEncoder();

    @Override
    public void save(User user) {
        Set<Role> roles = new HashSet<>();

        roles.add(new Role("USER", new HashSet<>()));
        roleRepository.saveAll(roles);
        //user.setPassword(bCryptPasswordEncoder().encode(user.getPassword())));
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthenticationProvider(authenticationProvider.LOCAL.toString());
        user.setRoles(roles);

        userRepository.save(user);
    }

    @Override
    public void saveAdmin(User user) {

        Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
        logger.info("burasi saveAdminin ici");
        Set<Role> roles = new HashSet<>();

        roles.add(new Role("ADMIN", new HashSet<>()));
        roleRepository.saveAll(roles);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(roles);

        userRepository.save(user);
    }

    public void saveUserAfterOAuthLogin(String email, String fullName, AuthenticationProvider authenticationProvider) {
        User user = new User();
        user.setUsername(fullName);
        user.setEmail(email);

        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
