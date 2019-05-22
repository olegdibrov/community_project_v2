package com.my_cash_machine.service;

import com.my_cash_machine.domen.News;

import java.util.Collection;

public interface NewsService {

    News save(News news);

    Boolean delete(int id);

    News update(News news);

    News findById(int id);


    Collection<News> findAll();
}
