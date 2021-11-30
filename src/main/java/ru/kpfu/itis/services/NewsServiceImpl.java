package ru.kpfu.itis.services;

import ru.kpfu.itis.models.News;
import ru.kpfu.itis.repositories.NewsRepository;

import java.util.List;

public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public void save(News entity) {
        newsRepository.save(entity);
    }

    @Override
    public void delete(News entity) {
        newsRepository.delete(entity);
    }

    @Override
    public void update(News entity) {
        newsRepository.update(entity);
    }

    @Override
    public List<News> findByTag(String tagName) {
        return newsRepository.findByTag(tagName);
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }
}
