package com.eldar.invitation.service;

import com.eldar.invitation.dto.PersonRequestDTO;
import com.eldar.invitation.dto.PersonResponseDTO;
import com.eldar.invitation.model.Person;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PersonService {

    @Transactional
    Boolean addPerson(PersonRequestDTO person) throws Exception;

    @Transactional
     List<PersonResponseDTO> getPersons();

    @Transactional
    PersonResponseDTO getPerson(Long oid);

    @Transactional
    Boolean deletePerson(Long oid) throws Exception;

    @Transactional
    Boolean updatePerson(PersonRequestDTO person) throws Exception;
}
