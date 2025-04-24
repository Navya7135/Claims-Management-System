package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.MyUserDetails;
import com.cognizant.Repository.UserRepository;
import com.cognizant.model.User;



@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
    UserRepository repo;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	User u=repo.findByMemberId(username); 
        if(u==null)
            throw new UsernameNotFoundException("UsernameNotFoundException");
        return new MyUserDetails(u);
    }
}
