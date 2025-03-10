package com.gom.myapp_mysql.repository;

import com.gom.myapp_mysql.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository implements PersonDAO {
    private EntityManager entityManager;

    @Autowired
    public PersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Person person) {
        this.entityManager.persist(person);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        var person = this.entityManager.find(Person.class, id);
        this.entityManager.remove(person);
    }

    @Override
    @Transactional
    public Person find(Integer id) {
        return this.entityManager.find(Person.class, id);
    }

    @Override
    public List<Person> getAll() {
        TypedQuery<Person> query = this.entityManager.createQuery("From Person", Person.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Person person) {
        this.entityManager.merge(person);
    }
}
