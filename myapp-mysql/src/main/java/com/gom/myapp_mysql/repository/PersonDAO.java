package com.gom.myapp_mysql.repository;

import com.gom.myapp_mysql.entity.Person;

import java.util.List;

public interface PersonDAO {
    void save(Person person);
    void delete(Integer id);
    Person find(Integer id);
    List<Person> getAll();
    void update(Person person);
}
