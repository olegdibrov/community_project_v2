package com.my_cash_machine.service.impl;


import com.my_cash_machine.domen.Person;
import com.my_cash_machine.repository.PersonRepository;
import com.my_cash_machine.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Boolean delete(int id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Person update(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person findById(int id) {
        return personRepository.findById(id).get();
    }


    @Override
    public Person findByEmail(String name) {
        return personRepository.findByEmail(name);
    }

    @Override
    public Collection<Person> findAll() {
        Iterable<Person> itr = personRepository.findAll();
        return (Collection<Person>) itr;
    }
}
