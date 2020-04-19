package kz.iitu.library.service;

import kz.iitu.library.model.User;
import kz.iitu.library.repository.UserRepository;
import kz.iitu.library.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class UserService implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByID(Long id)
    {
        return userRepository.findById(id).get();
    }

    public User createUser(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.saveAndFlush(user);
        return user;
    }

    public void updateUser(Long id, User user)
    {
        User userDb = userRepository.findById(id).orElse(null);

        if (userDb != null)
        {
            userDb.setUsername(user.getUsername());
            userDb.setPassword(user.getPassword());

            userRepository.saveAndFlush(userDb);
        }
    }

    public void deleteUser(Long id)
    {
        User user = new User();
        user.setId(id);
        userRepository.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userRepository.findUserByUsername(username);

        if (user == null)
        {
            throw new UsernameNotFoundException("User: " + username + " not found!");
        }

        return user;
    }


}
