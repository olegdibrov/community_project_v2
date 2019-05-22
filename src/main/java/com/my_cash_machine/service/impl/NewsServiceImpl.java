package com.my_cash_machine.service.impl;

import com.my_cash_machine.domen.News;
import com.my_cash_machine.repository.NewsRepository;
import com.my_cash_machine.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public News save(News news) {
        return newsRepository.save(news);
    }

    @Override
    public Boolean delete(int id) {
        if (newsRepository.existsById(id)) {
            newsRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public News update(News news) {
        return newsRepository.save(news);
    }

    @Override
    public News findById(int id) {
        return newsRepository.findById(id).get();
    }


    @Override
    public Collection<News> findAll() {
        Iterable<News> itr = newsRepository.findAll();
        return (Collection<News>) itr;
    }
}
