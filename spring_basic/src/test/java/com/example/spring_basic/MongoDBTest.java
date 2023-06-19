package com.example.spring_basic;


import com.example.spring_basic.entity.Article;
import com.example.spring_basic.entity.User;
import com.example.spring_basic.service.ArticleService;
import com.example.spring_basic.service.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
/**
 * @RunWith(SpringRunner.class)
 * @SpringBootTest(classes=SpringBasicApplication.class) public class MongoDBTest {
 * @Autowired ArticleService articleService;
 * @Autowired private IUserService userService;
 * //进行mongoDB的测试
 * //@Test
 * @Test public void testMongoDB(){
 * //创建一个文章对象
 * Article article = new Article();
 * article.setArticleName("测试文章");
 * article.setContent("测试文章内容");
 * //测试添加ID
 * article.setId("5f0b6b4b9b9b7e1b7c7b7b7b");
 * articleService.create(article);
 * System.out.println("创建成功");
 * // Article article1 = articleService.get("5f0b6b4b9b9b7e1b7c7b7b7b");
 * // System.out.println(article1);
 * // System.out.println("查询成功");
 * // articleService.delete("5f0b6b4b9b9b7e1b7c7b7b7b");
 * // System.out.println("删除成功");
 * }
 * @Test public  void testMongoDB2(){
 * Article article = articleService.get("5f0b6b4b9b9b7e1b7c7b7b7b");
 * if(article!=null){
 * System.out.println(article);
 * }else {
 * System.out.println("没有查询到数据");
 * }
 * }
 * @Test public void  testMysql(){
 * List<User> onePageUser = userService.getOnePageUser(1, 2);
 * for (User user : onePageUser) {
 * System.out.println(user);
 * }
 * }
 * }
 **/