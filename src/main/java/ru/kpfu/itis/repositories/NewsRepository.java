package ru.kpfu.itis.repositories;

import ru.kpfu.itis.models.News;

import java.util.List;

public interface NewsRepository extends CrudRepository<News> {
    List<News> findByTag(String tagName);
}
