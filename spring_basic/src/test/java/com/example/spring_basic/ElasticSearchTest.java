package com.example.spring_basic;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class ElasticSearchTest {
    private RestHighLevelClient client;

    @Test
    public void elaTest() {
        System.out.println("测试ElasticSearch");
        this.client = new RestHighLevelClient(RestClient.builder(HttpHost.create("http://localhost:9200")));
        System.out.println("获得client: " + client);
    }

    /*@BeforeEach
    public void init() {
        System.out.println("初始化");
        this.client= new RestHighLevelClient(RestClient.builder(HttpHost.create("http://localhost:9200")));
    }*/
    @AfterEach
    public void close() {
        System.out.println("关闭");
        try {
            this.client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
