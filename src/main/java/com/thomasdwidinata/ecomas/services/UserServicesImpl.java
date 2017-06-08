package com.thomasdwidinata.ecomas.services;

import com.thomasdwidinata.ecomas.dao.UserDao;
import com.thomasdwidinata.ecomas.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServicesImpl implements UserServices {
    
    @Autowired
    private UserDao dao;
    
    @Override
    public void saveUser(User user)
    {
        dao.saveUser(user);
    }
    
    @Override
    public List<User> findAllUser()
    {
        return dao.findAllUser();
    }
    
    @Override
    public void deleteUserById(String id)
    {
        dao.deleteUserById(id);
    }
    
    @Override
    public User findById(String id)
    {
        return dao.findById(id);
    }
    
    @Override
    public void updateUser(User user)
    {
        dao.updateUser(user);
    }
}
