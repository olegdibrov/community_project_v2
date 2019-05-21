package com.my_cash_machine.repository;

import com.my_cash_machine.domen.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Integer> {
    Community findByName(String name);
}
