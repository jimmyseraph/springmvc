package com.testops.tr02.daos;

import com.testops.tr02.entities.User;

public interface UserDao {
    User getUserByName(String name);
}
