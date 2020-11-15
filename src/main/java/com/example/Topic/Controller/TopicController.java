package com.example.Topic.Controller;

import com.example.Topic.Model.Topic;
import com.example.Topic.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping(value = "/topics", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Topic> getTopics(){
        return topicService.getAllTopics();
    }

    @GetMapping(value = "/topics/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Topic getTopicByID(@PathVariable String id){
        return topicService.getTopicByID(id);
    }

    @PostMapping(value = "/topics", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void addTopic(@RequestBody List<Topic> topics){
        topics.forEach(topic -> topicService.addTopic(topic));
    }

    @RequestMapping(method = RequestMethod.PUT, value="/topics/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void updateTopic(@PathVariable String id, @RequestBody Topic topic){
        topicService.updateTopic(id, topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}
