package com.baris.ertas.LibraryApplicaton.service;

import com.baris.ertas.LibraryApplicaton.util.AuthenticationProvider;
import com.baris.ertas.LibraryApplicaton.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

    void saveAdmin(User user);

    User findByEmail(String email);

    void saveUserAfterOAuthLogin(String email, String fullName, AuthenticationProvider authenticationProvider);
}
