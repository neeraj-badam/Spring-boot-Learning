package com.telusko.WebApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        /*
        http.csrf( customizer -> customizer.disable() );
        Customizer<CsrfConfigurer<HttpSecurity>> csrfConfigurerCustomizer = new Customizer<CsrfConfigurer<HttpSecurity>>() {
            @Override
            public void customize(CsrfConfigurer<HttpSecurity> customizer) {
                customizer.disable();
            }
        };
        http.authorizeHttpRequests( req -> req.anyRequest().authenticated() );
//        http.formLogin( Customizer.withDefaults() );
        // This is to login to through rest requests and get response instead of formLogin page like postman
        http.httpBasic( Customizer.withDefaults() );
        // If we keep the http session stateless, then we will get the login form again and again because it's stateless and the postman will work with new Session Id everytime. So, we'll comment loginForm
        http.sessionManagement( session -> session.sessionCreationPolicy( SessionCreationPolicy.STATELESS ) );

         */
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests( req -> req
                        .requestMatchers("register", "login")
                        .permitAll()
                        .anyRequest().authenticated())
                .httpBasic( Customizer.withDefaults() )
                .sessionManagement( session -> session.sessionCreationPolicy( SessionCreationPolicy.STATELESS ) )
                .build()
                ;

        // return http.build();
    }

    /*
    // This method is used to authenticate the users based on hardcoded values
    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user1 = User
                .withDefaultPasswordEncoder()
                .username("neeraj")
                .password("neeraj")
                .roles("USER")
                .build();

        UserDetails user2 = User
                .withDefaultPasswordEncoder()
                .username("raj")
                .password("raj")
                .roles("USER")
                .build();

        // As this constructor can take var args, we can send as many users
        return new InMemoryUserDetailsManager( user1, user2 );
    }
     */

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        // We are not using any password encoder
        // authProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        authProvider.setPasswordEncoder( new BCryptPasswordEncoder(12));

        authProvider.setUserDetailsService( userDetailsService );

        return authProvider;
    }

    // This is used for login to replace the default login form of Spring Boot
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration
                .getAuthenticationManager();
    }

}