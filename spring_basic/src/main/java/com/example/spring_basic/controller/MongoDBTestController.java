package com.example.spring_basic.controller;

import com.example.spring_basic.entity.Article;
import com.example.spring_basic.entity.ChatMessage;
import com.example.spring_basic.service.ArticleService;
import com.example.spring_basic.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/testMongoDB")
public class MongoDBTestController {

    @Autowired
    private ArticleService articleService;

    private ChatMessageService chatMessageService;

    @Autowired
    public MongoDBTestController(ChatMessageService chatMessageService) {
        this.chatMessageService = chatMessageService;
    }

    //新增一个Artice
    @PostMapping("/create")
    public void create(@RequestBody Article article) {
        Article article1 = new Article();
        article1.setArticleName(article.getArticleName());
        article1.setContent(article.getContent());
        int i = articleService.create(article1);
        System.out.println(i);
    }

    //删除一个Article
    @DeleteMapping("/delete")
    public void delete(@RequestParam String id) {
        int delete = articleService.delete(id);
        System.out.println(delete);
    }

    //修改一个Article(?拦截器无法对put请求进行放行)
    @PostMapping("/update")
    public void update(@RequestBody Article article) {
        Article article1 = new Article();
        article1.setId("64815a5c26b1c54d3672ee1a");
        article1.setArticleName(article.getArticleName());
        article1.setContent(article.getContent());
        int update = articleService.create(article1);
        System.out.println(update);
    }

    //根据id查找一个mongoDB Article
    @GetMapping("/getOneMember")
    public void getOneMember() {
        Article article = articleService.getById("648141b9efc6e1079ec50583");
        System.out.println(article);
    }

    //根据条件查找多个mongoDB Article
    @PostMapping("/getManyMember")
    public void getManyMember(@RequestBody Article article) {
        List<Article> articleList = articleService.getByCondition(article);
        for (Article ele : articleList) {
            System.out.println(ele);
        }
    }

    @GetMapping("/createChatMessage")
    public int createChatMessage() {
        int i = chatMessageService.create();
        return i;
    }

    @PostMapping("/getChatMessage")
    public ChatMessage getChatMessage(@RequestBody ChatMessage chatMessage) {
        ChatMessage message = chatMessageService.getByCondition(chatMessage);
        return message;
    }

    @PostMapping("/getChatMessageByDetail")
    public List<ChatMessage> getChatMessageByDetailCondition(@RequestBody ChatMessage chatMessage) {
        List<ChatMessage> messageList = chatMessageService.getByDetailCondition(chatMessage);
        return messageList;
    }

    @PostMapping("/getChat")
    public List<ChatMessage> getChat(HttpServletResponse httpServletResponse, @RequestBody ChatMessage chatMessage) {
        List<ChatMessage> messageList = chatMessageService.getByDetailCondition(chatMessage);
        httpServletResponse.setContentType("application/vnd.ms-excel");
        httpServletResponse.setCharacterEncoding("utf-8");
        return messageList;
    }
}
