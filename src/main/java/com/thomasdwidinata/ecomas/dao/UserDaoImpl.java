package com.thomasdwidinata.ecomas.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.thomasdwidinata.ecomas.models.User;

/**
 *
 * @author thomasdwidinata
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao{
    @Override
    @Transactional
    public void saveUser(User user)
    {
        persist(user);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAllUser()
    {
        Criteria c = getSession().createCriteria(User.class);
        return (List<User>) c.list();
    }
    
    @Override
    @Transactional
    public void deleteUserById(String id)
    {
        Query q = getSession().createSQLQuery("DELETE FROM `user` WHERE `userid` = :id");
        q.setString("id", id);
        q.executeUpdate();
    }
    
    @Override
    public User findById(String id)
    {
        Criteria c = getSession().createCriteria(User.class);
        c.add(Restrictions.eq("id", id));
        return (User) c.uniqueResult();
    }
    
    @Override
    @Transactional
    public void updateUser(User user)
    {
        getSession().update(user);
    }
}
