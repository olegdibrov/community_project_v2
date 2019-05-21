package com.my_cash_machine.service;

import com.my_cash_machine.domen.Person;

import java.util.Collection;

public interface PersonService {
    Person save(Person person);

    Boolean delete(int id);

    Person update(Person person);

    Person findById(int id);

    Person findByEmail(String email);

    Collection<Person> findAll();
}
