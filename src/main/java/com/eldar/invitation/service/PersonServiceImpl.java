package com.eldar.invitation.service;

import com.eldar.invitation.dto.PersonRequestDTO;
import com.eldar.invitation.dto.PersonResponseDTO;
import com.eldar.invitation.enumeration.DocumentType;
import com.eldar.invitation.model.Person;
import com.eldar.invitation.repository.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonDAO personDAO;

    @Override
    public Boolean addPerson(PersonRequestDTO personDTO) throws Exception {
        Person person = dtoToEntity(personDTO);
        return personDAO.addPerson(person);
    }

    @Override
    public List<PersonResponseDTO> getPersons() {
        List<PersonResponseDTO> personResponseDTOS = new ArrayList<>();
        for (Person person: personDAO.getPersons()) {
            PersonResponseDTO personResponseDTO = entityToDTO(person);
            personResponseDTOS.add(personResponseDTO);
        }
        return personResponseDTOS;
    }

    @Override
    public PersonResponseDTO getPerson(Long oid) {
        return entityToDTO(personDAO.getPerson(oid));
    }

    @Override
    public Boolean deletePerson(Long oid) throws Exception {
        Person person = personDAO.getPerson(oid);
        Boolean result = personDAO.deletePerson(person);
        return result;
    }

    @Override
    public Boolean updatePerson(PersonRequestDTO personDTO) throws Exception {
        Person person = dtoToEntity(personDTO);
        return personDAO.updatePerson(person);
    }

    private static Person dtoToEntity(PersonRequestDTO personDTO) {
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setLastName(personDTO.getLastName());
        person.setDocumentType(DocumentType.valueOf(personDTO.getDocumentType()));
        person.setDocumentNumber(Integer.valueOf(personDTO.getDocumentNumber()));
        return person;
    }

    private static PersonResponseDTO entityToDTO(Person person) {
        PersonResponseDTO personResponseDTO = new PersonResponseDTO();
        personResponseDTO.setOid(person.getOid());
        personResponseDTO.setName(person.getName());
        personResponseDTO.setLastName(person.getLastName());
        personResponseDTO.setDocumentType(String.valueOf(person.getDocumentType()));
        personResponseDTO.setDocumentNumber(String.valueOf(person.getDocumentNumber()));
        return personResponseDTO;
    }

}
