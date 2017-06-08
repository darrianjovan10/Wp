package com.thomasdwidinata.ecomas.services;

import com.thomasdwidinata.ecomas.models.User;
import java.util.List;

/**
 *
 * @author thomasdwidinata
 */
public interface UserServices {
    void saveUser(User user);
    List<User> findAllUser();
    void deleteUserById(String id);
    User findById(String id);
    void updateUser(User user);
}
