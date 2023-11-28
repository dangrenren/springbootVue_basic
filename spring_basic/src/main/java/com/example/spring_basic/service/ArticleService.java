package com.example.spring_basic.service;

import com.example.spring_basic.entity.Article;
import java.util.List;

public interface ArticleService {
    int create(Article article);

    int delete(String id);

    Article getById(String id);

    void update(Article article);

    List<Article> getByCondition(Article condition);
}
