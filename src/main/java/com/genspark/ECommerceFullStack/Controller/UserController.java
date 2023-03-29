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

    // Step 2
    @Autowired
    private UserService userService;

    @GetMapping(path = "/users")
    public List<User> getUsers() throws IOException {
        return this.userService.getAllUsers();
    }

    @PostMapping(value = "/users")
    public User addUser(@RequestBody User user) throws IOException {
        return this.userService.addUser(user);
    }

    @GetMapping("/users/{userID}")
    public User getUserByID(@PathVariable String userID) {
        return this.userService.getUserByID(Integer.parseInt(userID));
    }

    // TODO: might need to change the put methods later to match post
    @PutMapping(value = "/users", consumes = {"application/x-www-form-urlencoded"})
    public User updateUser(@ModelAttribute User user) {
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/users/{productID}")
    public String deleteUsers(@PathVariable String userID) {
        return this.userService.deleteUserByID(Integer.parseInt(userID));
    }
}
