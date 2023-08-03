package com.eldar.invitation.repository;

import com.eldar.invitation.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public Person getPerson(Long oid) {
        return entityManager.find(Person.class ,oid);
    }

    @Transactional
    @Override
    public List<Person> getPersons() {
        String query = "from Person";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Boolean addPerson(Person person) throws Exception {
        Boolean works;
        try {
            entityManager.persist(person);
            works = Boolean.TRUE;
        }catch (Exception e){
            throw new Exception("No se pudo agregar una nueva persona.");
        }

        return works;
    }

    @Override
    public Boolean deletePerson(Person person) throws Exception {
        Boolean works;
        try {
            entityManager.remove(person);
            works = Boolean.TRUE;
        }catch (Exception e){
            throw new Exception("No se pudo eliminar una nueva persona.");
        }
        return works;
    }

    @Override
    public Boolean updatePerson(Person person) throws Exception {
        Boolean works;
        try {
            entityManager.merge(person);
            works = Boolean.TRUE;
        }catch (Exception e){
            throw new Exception("No se pudo editar una nueva persona.");
        }
        return works;
    }
}
