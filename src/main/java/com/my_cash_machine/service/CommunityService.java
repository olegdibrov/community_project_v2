package com.my_cash_machine.service;

import com.my_cash_machine.domen.Community;

import java.util.Collection;

public interface CommunityService {

    Community save(Community person);

    Boolean delete(int id);

    Community update(Community person);

    Community findById(int id);

    Community findByName(String name);

    Collection<Community> findAll();
}
