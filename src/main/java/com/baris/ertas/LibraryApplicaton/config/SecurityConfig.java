package com.baris.ertas.LibraryApplicaton.config;

import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        UserDetails adminUser = User
                .withUsername("admin")
                .password(encoder().encode("admin123"))
                .authorities("FULL_PRIVILIGES")
                .roles("ADMIN")
                .build();

        UserDetails regularUser = User
                .withUsername("user")
                .password(encoder().encode("user123"))
                .authorities("READ_ACCESS")
                .roles("USER")
                .build();

        manager.createUser(regularUser);
        manager.createUser(adminUser);

        return manager;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http
                .authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("ADMIN", "USER")
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll(); */

        /*http.authorizeRequests()
                .antMatchers("/home", "/login").permitAll()
                .antMatchers("/dashboard", "/h2-console").authenticated()
                .and()
                .formLogin()
                .loginPage("/login"); */


      /* http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/**")
                    .hasAnyRole("ADMIN", "USER")
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/home")
                    .failureUrl("/login?error=true")
                    .permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable(); */

        http.authorizeRequests()
                .antMatchers("login").permitAll()
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

    }

   /* @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring().antMatchers()
    } */
}
