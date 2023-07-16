package com.jameseng.javarestspringboot.services;

import com.jameseng.javarestspringboot.entities.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private static final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {
        logger.info("Find one person!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("James");
        person.setLastName("Medeiros");
        person.setAddress("Porto Alegre/RS");
        person.setGender("Male");
        return person;
    }

    public List<Person> findAll() {
        logger.info("Find all people");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++ ) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("LastName " + i);
        person.setAddress("Some address " + i);
        person.setGender(i%2 == 0 ? "Male" : "Feminine");
        return person;
    }

}
