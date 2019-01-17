package com.esliceu.dwes.authenticapi;

import com.esliceu.dwes.authenticapi.domain.Authenticate;
import com.esliceu.dwes.authenticapi.domain.Rol;
import com.esliceu.dwes.authenticapi.domain.Status;
import com.esliceu.dwes.authenticapi.domain.User;
import com.esliceu.dwes.authenticapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;


@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public Authenticate authenticate(@RequestBody User user) {

        Authenticate authenticate = new Authenticate();


        if (user != null &&
                user.getUserId() != null &&
                user.getPassword() != null) {

            User userOfRepo = userRepository.findUserById(user.getUserId());

            if (userOfRepo!= null &&
                    userOfRepo.getPassword().equals(user.getPassword())) {
                authenticate.setUser(userOfRepo);

                authenticate.setStatus(Status.authenticated);
            } else {
                authenticate.setStatus(Status.failed);
            }


        } else {
            authenticate.setStatus(Status.failed);
        }

        return authenticate;

    }


    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public Set<User> getAllUsers(){
        return userRepository.findAll();
    }
}
