package com.genspark.ECommerceFullStack.Controller;

import com.genspark.ECommerceFullStack.Entity.User;
import com.genspark.ECommerceFullStack.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
    
    // http://localhost:9080/api/users
    // autowired because UserService class is being injected into MyController class
    @Autowired
    private UserService userService;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/users")
    public List<User> getUsers() {
        return this.userService.getAllUser();
    }

    @GetMapping("/users/{productID}")
    public User getUserByID(@PathVariable String productID) {
        return this.userService.getUserByID(Integer.parseInt(productID));
    }

    @PostMapping("/users")
    public User addUser(@RequestParam User user) throws IOException {
//        String pwd = user.getPassword();
//        String encryptPwd = passwordEncoder.encode(pwd);
//        user.setPassword(encryptPwd);
        return this.userService.addUser(user);
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/users/{productID}")
    public String deleteUsers(@PathVariable String productID) {
        return this.userService.deleteUserByID(Integer.parseInt(productID));
    }
}
