package com.genspark.ECommerceFullStack.Controller;


import com.genspark.ECommerceFullStack.AuthenticationBean;
import com.genspark.ECommerceFullStack.Entity.User;
import com.genspark.ECommerceFullStack.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AuthController {

    @GetMapping(path = "/basicauth")
    public AuthenticationBean basicauth() {
        return new AuthenticationBean("You are authenticated");
    }
}