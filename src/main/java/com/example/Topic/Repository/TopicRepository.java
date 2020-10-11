package com.example.Topic.Repository;

import com.example.Topic.Model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {
}
