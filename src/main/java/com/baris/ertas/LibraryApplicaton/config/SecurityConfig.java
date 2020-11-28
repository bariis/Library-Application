package com.baris.ertas.LibraryApplicaton.config;

import com.baris.ertas.LibraryApplicaton.component.OAuth2LoginSuccessHandler;
import com.baris.ertas.LibraryApplicaton.service.CustomOAuth2UserService;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableEncryptableProperties
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("userDetailsServiceImpl")
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private CustomOAuth2UserService oAuth2UserService;

    @Autowired
    private OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/oauth2/**").permitAll()
                .antMatchers("/css/**", "/js/**", "/registration", "/h2-console/**", "/home", "/welcome", "/login","/api/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .oauth2Login()
                    .loginPage("/login")
                    .userInfoEndpoint().userService(oAuth2UserService)
                    .and().successHandler(oAuth2LoginSuccessHandler).defaultSuccessUrl("/home")
                .and().logout().permitAll();


        http.csrf().disable();
        http.headers().frameOptions().disable();

    }


    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public UserDetailsService configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        UserDetails adminUser = User
                .withUsername("admin")
                .password(encoder().encode("admin123"))
                .authorities("FULL_PRIVILIGES")
                .roles("ADMIN")
                .build();

        manager.createUser(adminUser);

        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());

        return manager;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    /*@Bean
    @Override
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        UserDetails adminUser = CustomUserDetails
                .withUsername("admin")
                .password(encoder().encode("admin123"))
                .authorities("FULL_PRIVILIGES")
                .roles("ADMIN")
                .build();

        UserDetails regularUser = CustomUserDetails
                .withUsername("user")
                .password(encoder().encode("user123"))
                .authorities("READ_ACCESS")
                .roles("USER")
                .build();

        manager.createUser(regularUser);
        manager.createUser(adminUser);

        return manager;
    } */

   /* @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/login", "/register", "/signUp").permitAll()
                .antMatchers( "/h2-console/**").hasRole("ADMIN").anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error=true")
                .permitAll()
                .and()
                .logout().permitAll();

        //http.exceptionHandling().accessDeniedPage("/403");
        http.csrf().disable();
        http.headers().frameOptions().disable();

    }*/
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

}
