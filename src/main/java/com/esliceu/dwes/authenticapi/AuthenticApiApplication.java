package com.esliceu.dwes.authenticapi;

import com.esliceu.dwes.authenticapi.domain.Rol;
import com.esliceu.dwes.authenticapi.domain.User;
import com.esliceu.dwes.authenticapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuthenticApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository, ApplicationContext context) {
        return args -> {

            User user = context.getBean(User.class);

            user.setEmail("aaaaaa@gmail.com");
            user.setName("Biel");
            user.setSurname("Bonet");
            user.setPassword("qwerty");
            user.getRols().add(Rol.admin);
            user.setUserId("bbonet");

            userRepository.addUser(user);

            user = context.getBean(User.class);

            user.setEmail("bbbbb@gmail.com");
            user.setName("Goretti");
            user.setSurname("Tur");
            user.setPassword("1234");
            user.getRols().add(Rol.user);
            user.setUserId("gtur");

            userRepository.addUser(user);



        };
    }

}

