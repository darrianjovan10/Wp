/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.dao;

import com.thomasdwidinata.ecomas.models.Unit;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface UnitDao {
      void saveUnit(Unit unit);
    List<Unit> findAllUnit();
    void deleteUnitById(String id);
    Unit findById(String id);
    void updateUnit(Unit unit);
}
