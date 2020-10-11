package com.DiplomskiRad.Videoteka.security;


import com.DiplomskiRad.Videoteka.service.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class Authentication extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("halco").password(passwordEncoder().encode("123")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("111")).roles("ADMIN","USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http

                .authorizeRequests()
                .antMatchers("/api/v1/videoteka/login").permitAll()
                .antMatchers("/api/v1/videoteka/error").permitAll()
                .antMatchers("/api/v1/videoteka/admin-add-delete/**").hasRole("ADMIN")
                .antMatchers("/api/v1/videoteka/movies").permitAll()
                .antMatchers("/api/v1/videoteka/series").permitAll()
                .antMatchers("/api/v1/videoteka/cartoons").permitAll()
                .antMatchers("/api/v1/videoteka/index").permitAll()
                .antMatchers("/css/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/api/v1/videoteka/login")
                .usernameParameter("userName").passwordParameter("password")
                .defaultSuccessUrl("/api/v1/videoteka/index",true)
                .failureUrl("/api/v1/videoteka/error");

         }


}
