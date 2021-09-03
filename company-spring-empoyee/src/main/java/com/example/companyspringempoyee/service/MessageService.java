package com.example.companyspringempoyee.service;

import com.example.companyspringempoyee.model.Message;
import com.example.companyspringempoyee.repazitory.MessageRepazitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepazitory messageRepazitory;

    public void saveMessage(Message massage){
        messageRepazitory.save(massage);
    }

    public List<Message> findAll() {
        return messageRepazitory.findAll();
    }
    public List<Message> findAllMessagesByToId(int id) {
        return messageRepazitory.findAllByToEmployee_Id(id);
    }
}
