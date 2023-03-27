package com.genspark.ECommerceFullStack.Service;

import com.genspark.ECommerceFullStack.Dao.UserDao;
import com.genspark.ECommerceFullStack.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUser() {
        return this.userDao.findAll();
    }

    @Override
    public User getUserByID(int productID) {
        Optional<User> c = this.userDao.findById(productID);
        User user = null;
        if (c.isPresent()) {
            user = c.get();
        } else {
            throw new RuntimeException(" User not found for id :: " + productID);
        }
        return user;
    }

    @Override
    public User addUser(User user) {
        return this.userDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        return this.userDao.save(user);
    }

    public String deleteUserByID(int productID) {
        this.userDao.deleteById(productID);
        return "Deleted Successfully";
    }
}
