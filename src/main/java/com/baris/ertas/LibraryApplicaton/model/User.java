package com.baris.ertas.LibraryApplicaton.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;

    @Column(unique = true)
    private String email;

    private String authenticationProvider;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User(String username, String password, String email, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getAuthenticationProvider() {
        return authenticationProvider;
    }

    public void setAuthenticationProvider(String authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
