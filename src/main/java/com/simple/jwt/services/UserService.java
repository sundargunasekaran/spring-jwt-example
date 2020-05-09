package com.simple.jwt.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.simple.jwt.model.User;

@Service
public class UserService
{
    private static Map<String, User> users = new HashMap<String, User>();
    
    static {
    	User user = new User();
        user.setUserName("user1");
        user.setPassWord("123");
        user.setEmail("user1@gmail.com");
        user.setRole(User.ROLE_ADMIN);
        user.setIsActivated(true);
        users.put("user1", user);
    }

    public User findUserByUserName(String userName)
    {
    	
        return users.get(userName);
    }


    public Boolean authenticate(String userName, String passWord)
    {
        User user = findUserByUserName(userName);
        if (null!=user)
        {
            return user.getPassWord().equals(passWord);
        }
        return false;
    }
}
