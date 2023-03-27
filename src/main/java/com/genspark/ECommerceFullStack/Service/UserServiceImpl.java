package com.genspark.ECommerceFullStack.Service;

import com.genspark.ECommerceFullStack.Dao.UserDao;
import com.genspark.ECommerceFullStack.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    //Step2.1 just this block. Encrypt passwords
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers() {
        return this.userDao.findAll();
    }

    @Override
    public User getUserByID(int userID) {
        Optional<User> c = this.userDao.findById(userID);
        User user = null;
        if (c.isPresent()) {
            user = c.get();
        } else {
            throw new RuntimeException(" User not found for id :: " + userID);
        }
        return user;
    }

    @Override
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        return this.userDao.save(user);
    }

    public String deleteUserByID(int userID) {
        this.userDao.deleteById(userID);
        return "Deleted Successfully";
    }
}
