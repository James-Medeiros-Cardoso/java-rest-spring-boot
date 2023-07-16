package com.jameseng.javarestspringboot.resources;

import com.jameseng.javarestspringboot.entities.Person;
import com.jameseng.javarestspringboot.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    @GetMapping(value = "/{id}") // http://localhost:8080/person/1
    public Person findById(@PathVariable(value = "id") String id) throws Exception {
        return personService.findById(id);
    }

    @GetMapping() // http://localhost:8080/person
    public List<Person> findAll() throws Exception {
        return personService.findAll();
    }
}