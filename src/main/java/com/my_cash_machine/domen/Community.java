package com.my_cash_machine.domen;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Transactional
@Table(name = "community")
public class Community {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="communities", fetch = FetchType.LAZY)
    private List<User> personList;

    @OneToMany
    private List<News> news;

    public Community() {
    }

    public Community(String name, List<News> news) {
        this.name = name;
        this.news = news;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    @Override
    public String toString() {
        return "Community{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", news=" + news +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Community community = (Community) o;
        return Objects.equals(id, community.id) &&
                Objects.equals(name, community.name) &&
                Objects.equals(news, community.news);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, news);
    }
}
