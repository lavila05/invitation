package com.eldar.invitation.controller;

import com.eldar.invitation.dto.PersonRequestDTO;
import com.eldar.invitation.dto.PersonResponseDTO;
import com.eldar.invitation.model.Person;
import com.eldar.invitation.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(path = "/person/{oid}")
    public ResponseEntity<PersonResponseDTO> getPerson(@PathVariable("oid") Long oid){
        return new ResponseEntity<>(personService.getPerson(oid), HttpStatus.OK);
    }

    @GetMapping(path = "/person")
    public ResponseEntity<List<PersonResponseDTO>> getPersons(){
        return new ResponseEntity<>(personService.getPersons(), HttpStatus.OK);
    }

    @PostMapping(path = "/person")
    public ResponseEntity<Boolean> addPerson(@RequestBody PersonRequestDTO personRequestDTO) throws Exception {

        Boolean result = personService.addPerson(personRequestDTO);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping(path = "/person/update")
    public ResponseEntity<Boolean> updatePerson(@RequestBody PersonRequestDTO personRequestDTO) throws Exception {

        Boolean result = personService.updatePerson(personRequestDTO);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(path = "/person/{oid}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable("oid") Long oid) throws Exception {

        Boolean result = personService.deletePerson(oid);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
