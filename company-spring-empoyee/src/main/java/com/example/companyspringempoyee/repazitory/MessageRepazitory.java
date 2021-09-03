package com.example.companyspringempoyee.repazitory;

import com.example.companyspringempoyee.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepazitory extends JpaRepository<Message, Integer> {

    List<Message> findAllByToEmployee_Id(int id);

}
