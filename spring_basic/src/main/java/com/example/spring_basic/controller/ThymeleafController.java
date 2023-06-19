package com.example.spring_basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.file.Files;

@Slf4j
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {
    @GetMapping("/image")
    public ResponseEntity<byte[]> testImage() throws IOException {
        // String imageURL = "static/renshu@2x.png";
        String imageURL = "static/weChat.jpg";
        ClassPathResource resource = new ClassPathResource(imageURL);
        byte[] imageBytes = Files.readAllBytes(resource.getFile().toPath());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(imageBytes, headers, 200);
    }
}
