package com.bakerygb.bgbapp.services;

import com.bakerygb.bgbapp.dao.UserRepository;
import com.bakerygb.bgbapp.models.User;
import com.bakerygb.bgbapp.models.UserPrinciple;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User newUser) {
        userRepository.save(newUser);
        log.warn("new User added to the database");
    }

    public void deleteUserById(Long id) {
        log.warn("User deleted from the database");
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        log.warn("All Users listed " + allUsers.toString());
        return allUsers;
    }

    public User getUserById(Long id) {
        User foundUser = userRepository.getById(id);
        log.warn("Id: " + id + "\nFound User: " + foundUser);
        return foundUser;
    }

    //this class is overridden for Spring Security log in
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }


        return new UserPrinciple(user);
    }
}
