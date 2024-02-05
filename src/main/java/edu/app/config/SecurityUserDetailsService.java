package edu.app.config;


import java.util.Optional;

import edu.app.domains.User;
import edu.app.respo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class SecurityUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not present");
        }
        User user = userOptional.get();
        return user;
    }

    public void createUser(UserDetails user) {
        // You can't save UserDetails directly, so you might need to convert it to your
        // User class
        // and save it in the UserRepository.
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());

        userRepository.save(newUser);
    }
}