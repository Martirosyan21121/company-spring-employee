package com.example.companyspringempoyee.service;

import com.example.companyspringempoyee.model.Topic;
import com.example.companyspringempoyee.repazitory.TopicRepazitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TopicService {

    public TopicRepazitory topicRepazitory;

    public List<Topic> findAllByCompanyId(int id){
        return topicRepazitory.findAllByCompanyId(id);
    }
    public Optional<Topic> findTopicById(int id){
        return topicRepazitory.findById(id);
    }

    public void saveTopic(Topic topic){
        topicRepazitory.save(topic);
    }
}
