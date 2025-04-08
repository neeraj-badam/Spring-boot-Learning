package com.telusko.WebApp.service;

import com.telusko.WebApp.model.Users;
import com.telusko.WebApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTService jwtService;

    public Users register(Users user){
        user.setPassword( encoder.encode(user.getPassword()) );
        return repo.save(user);
    }

    public String verify(Users user) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        if ( auth.isAuthenticated() ){
            return jwtService.generateToken( user.getUsername() );
        }
        return "Fail";
    }
}