/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.dao;

import com.thomasdwidinata.ecomas.models.Unit;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Repository("unitDao")
public class UnitDaoImpl extends AbstractDao implements UnitDao {
       @Override
    @Transactional
    public void saveUnit(Unit unit)
    {
        persist(unit);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<Unit> findAllUnit()
    {
        Criteria c = getSession().createCriteria(Unit.class);
        return (List<Unit>) c.list();
    }
    
    @Override
    @Transactional
    public void deleteUnitById(String id)
    {
        Query q = getSession().createSQLQuery("DELETE FROM `unit` WHERE `UnitID` = :id");
        q.setString("id", id);
        q.executeUpdate();
    }
    
    @Override
    public Unit findById(String id)
    {
        Criteria c = getSession().createCriteria(Unit.class);
        c.add(Restrictions.eq("id", id));
        return (Unit) c.uniqueResult();
    }
    
    @Override
    @Transactional
    public void updateUnit(Unit unit)
    {
        getSession().update(unit);
    }
}
