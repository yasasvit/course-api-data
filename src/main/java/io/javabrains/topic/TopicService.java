package io.javabrains.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring Framework Description"),
            new Topic("java", "Core Java", "Core Java Description"),
            new Topic("javascript", "JavaScript", "JavaScript Description")
    ));

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        Iterable<Topic> iterable = topicRepository.findAll();
        for (Topic t: iterable) {
            topics.add(t);
        }
        return topics;
    }

    public Topic getTopic(String id) {
//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Topic not found for " + id));
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id) {
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}
