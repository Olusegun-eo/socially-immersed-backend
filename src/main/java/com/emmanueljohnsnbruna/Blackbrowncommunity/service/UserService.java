package com.emmanueljohnsnbruna.Blackbrowncommunity.service;

import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.User;
import com.emmanueljohnsnbruna.Blackbrowncommunity.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }

    public User getCurrentUser(String userName) {
      User user =  userRepository.findByUsername(userName);
        if(user == null) throw new UsernameNotFoundException(userName);
        return user;
    }
}
