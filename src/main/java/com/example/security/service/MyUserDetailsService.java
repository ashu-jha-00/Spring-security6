package com.example.security.service;

import com.example.security.model.UserPrincipal;
import com.example.security.model.Users;
import com.example.security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repo.findByUsername(username);

        if(user == null){
            System.out.println("Username not found :>>>>>>>>>>>>>>>>>>>>>>>");
            throw new UsernameNotFoundException("user not found");
        }

        return new UserPrincipal(user);
    }
}
