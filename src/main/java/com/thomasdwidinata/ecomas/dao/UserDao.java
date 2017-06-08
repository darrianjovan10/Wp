package com.thomasdwidinata.ecomas.dao;

import java.util.List;
import com.thomasdwidinata.ecomas.models.User;

/**
 *
 * @author thomasdwidinata
 */
public interface UserDao {
    void saveUser(User user);
    List<User> findAllUser();
    void deleteUserById(String id);
    User findById(String id);
    void updateUser(User user);
}
