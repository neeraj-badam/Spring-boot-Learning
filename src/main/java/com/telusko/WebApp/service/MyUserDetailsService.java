package com.telusko.WebApp.service;

import com.telusko.WebApp.model.UserPrincipal;
import com.telusko.WebApp.model.Users;
import com.telusko.WebApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername( username );

        if ( user == null ){
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User Not Found");
        }


        return new UserPrincipal( user );
    }
}