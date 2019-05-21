package com.my_cash_machine.domen;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Person extends User {
    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ManyToOne
    private Community communities;


    public Person(String name, String surname, Community communities) {
        this.name = name;
        this.surname = surname;
        this.communities = communities;
    }



    public Person(String email, String password, String confirmPassword, Integer role, String name, String surname, Community communities) {
        super(email, password, confirmPassword, role);
        this.name = name;
        this.surname = surname;
        this.communities = communities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Community getCommunities() {
        return communities;
    }

    public void setCommunities(Community communities) {
        this.communities = communities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(communities, person.communities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, communities);
    }
}
