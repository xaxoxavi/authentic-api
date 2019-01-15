package com.esliceu.dwes.authenticapi;

import com.esliceu.dwes.authenticapi.domain.Authenticate;
import com.esliceu.dwes.authenticapi.domain.Rol;
import com.esliceu.dwes.authenticapi.domain.Status;
import com.esliceu.dwes.authenticapi.domain.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AuthController {

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public Authenticate authenticate (@RequestBody User user){

        Authenticate authenticate = new Authenticate();
        authenticate.setUser(user);

        if (user != null &&
                user.getUserId() != null &&
                user.getPassword() != null &&
                user.getPassword().equals(user.getUserId())
                ){


            authenticate.getUser().getRols().add(Rol.admin);
            authenticate.setStatus(Status.authenticated);

        } else {
            authenticate.setStatus(Status.failed);
        }

        return  authenticate;

    }
}
