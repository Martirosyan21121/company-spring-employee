package com.example.companyspringempoyee.repazitory;

import com.example.companyspringempoyee.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepazitory extends JpaRepository<Topic, Integer> {

    List<Topic> findAllByCompanyId(int id);

}
