package com.example.Topic.Controller;

import com.example.Topic.Model.Topic;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @RequestMapping("/topic")
    public List<Topic> getTopics(){
        return Arrays.asList(
                new Topic("java", "Core Java", "Core Java Description"),
                new Topic("spring", "Spring Boot", "Spring Boot Description" ),
                new Topic("javascript", "ecma6", "ES6 description")
        );
    }
}
