package com.example.Course;

import com.example.Topic.Model.Topic;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    private String id;
    private String name;
    private String description;
    @ManyToOne(optional = false)
    @JoinColumn
    private Topic topic;


    public Course(){}

    public Course(String id, String name, String description, Topic topic) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.topic = topic;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
