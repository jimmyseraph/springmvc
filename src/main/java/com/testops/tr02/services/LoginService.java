package com.testops.tr02.services;

import com.testops.tr02.daos.UserDao;
import com.testops.tr02.entities.User;
import com.testops.tr02.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserDao userDao;
    public boolean doLogin(String username, String password){
        User user = userDao.getUserByName(username);
        password = MD5Util.toMD5String(password);
        if(user == null){
            return false;
        }
        if(user.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }
}
