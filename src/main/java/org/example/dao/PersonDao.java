package org.example.dao;

import org.example.domain.Person;

public interface PersonDao {


     void save();
     void update();

     void delete();
     Person findById(Long id);
}
