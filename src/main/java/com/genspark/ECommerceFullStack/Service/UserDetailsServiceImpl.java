package com.genspark.ECommerceFullStack.Service;

import com.genspark.ECommerceFullStack.Dao.UserDao;
import com.genspark.ECommerceFullStack.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> {
                            System.out.println("Not in here");
                            System.out.println("Not in here");
                            return new UsernameNotFoundException("User not found with username: " + username);
                        }
                );
        return new CustomUserDetails(user);
    }
}
