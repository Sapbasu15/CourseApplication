package com.example.Topic.Service;

import com.example.Topic.Model.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private static List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("java", "Core Java", "Core Java Description"),
                new Topic("spring", "Spring Boot", "Spring Boot Description" ),
                new Topic("javascript", "ecma6", "ES6 description")
        ));

    public List<Topic> getAllTopics(){
        return topics;
    }

    public Topic getTopicByID(String id){
        return topics.stream().filter(t -> t.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic){
        for(int i=0; i<topics.size(); i++){
            if(topics.get(i).getId().equals(id)){
                topics.set(i, topic);
                break;
            }
        }
    }

    public void deleteTopic(String id){
        topics.removeIf(topic -> topic.getId().equals(id));
    }

}
