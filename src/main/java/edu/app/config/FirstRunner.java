package edu.app.config;

import edu.app.domains.User;
import edu.app.respo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class FirstRunner implements ApplicationRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        defualtAdmin();
    }
    public  void defualtAdmin(){
        if(userRepository.count()==0){
          //Admin admin@1234
            User user=new User();
            String password="Admin@1234";
            user.setUsername("Admin");
            user.setPassword(passwordEncoder.encode(password));
            userRepository.save(user);
        }
    }
}
