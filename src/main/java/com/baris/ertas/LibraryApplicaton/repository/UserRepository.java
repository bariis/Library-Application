package com.baris.ertas.LibraryApplicaton.repository;

import com.baris.ertas.LibraryApplicaton.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
