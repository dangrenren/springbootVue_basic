package com.example.spring_basic.service;

import com.example.spring_basic.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired //自动注入
    private MongoTemplate mongoTemplate;

    @Override
    public int create(Article article) {
        Article save = mongoTemplate.save(article);
        return 1;
    }

    /**
     * 删除文章
     *
     * @param
     */
    @Override
    public int delete(String id) {
        List<Article> deleteList = new ArrayList<>();
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Article.class);
        return 1;
    }

    //改
    @Override
    public void update(@RequestBody Article article) {
        mongoTemplate.save(article);
    }

    //查
    @Override
    public Article getById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Article article = mongoTemplate.findOne(query, Article.class);
        System.out.println(article);
        return article;
    }

    @Override
    public List<Article> getByCondition(Article condition) {
        Query query = new Query();
        // query.addCriteria(Criteria.where("articleName").regex(String.valueOf(condition)));
        query.addCriteria(Criteria.where("article_name").is("小静崽"));

        List<Article> articleList = mongoTemplate.find(query, Article.class);
        System.out.println(articleList);
        return articleList;
    }
}
