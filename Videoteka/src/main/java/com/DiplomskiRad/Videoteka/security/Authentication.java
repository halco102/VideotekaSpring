package com.DiplomskiRad.Videoteka.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class Authentication extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService customUserDetails;


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .userDetailsService(customUserDetails)
                .passwordEncoder(passwordEncoder());


        /*
        * U user tabeli treba dodati odma na 1 mjestu admin i dodijelit mu u User_Role tabeli admin privilegiju
        * svaki ostali account dodijelit vrijednost (2) user i napraviti u db Trigger koji ce automatski
        * dodijeliti vrijednost (2) User role
        *
        * */

/*        auth.inMemoryAuthentication()
                .withUser("halco").password(passwordEncoder().encode("123")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("111")).roles("ADMIN","USER")
                .and()
                .withUser("weejws").password(passwordEncoder().encode("222")).roles("USER");    hardcoded users*/


    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/v1/videoteka/login").permitAll()
                .antMatchers("/api/v1/videoteka/error").permitAll()
                .antMatchers("/api/v1/videoteka/admin-add-delete/**").hasAuthority("ADMIN")
                .antMatchers("/api/v1/videoteka/movies").permitAll()
                .antMatchers("/api/v1/videoteka/series").permitAll()
                .antMatchers("/api/v1/videoteka/cartoons").permitAll()
                .antMatchers("/api/v1/videoteka/index").hasAnyAuthority("USER","ADMIN") //provjerava da li ulogovani acc ima authority na ovoj domeni
                .antMatchers("/api/v1/videoteka/create-account").permitAll()
                .antMatchers("/css/**").permitAll()
                //.anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/api/v1/videoteka/login")
                .usernameParameter("userName").passwordParameter("password")
                .defaultSuccessUrl("/api/v1/videoteka/index",true);
               // .failureUrl("/api/v1/videoteka/error");
            http.csrf().disable();
         }

    @Override
    public void configure(WebSecurity web) throws Exception {  //ignore login for h2
        web
                .ignoring()
                .antMatchers("/h2-console/**");
    }
}
