package com.eldar.invitation.repository;

import com.eldar.invitation.model.Person;

import java.util.List;

public interface PersonDAO {

    Person getPerson(Long oid);

    List<Person> getPersons();

    Boolean addPerson(Person person) throws Exception;

    Boolean deletePerson(Person person) throws Exception;

    Boolean updatePerson(Person person) throws Exception;
}
