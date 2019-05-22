package com.my_cash_machine.repository;

import com.my_cash_machine.domen.Community;
import com.my_cash_machine.domen.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Integer> {
}
