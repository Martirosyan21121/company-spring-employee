package com.example.companyspringempoyee.service;

import com.example.companyspringempoyee.model.Comment;
import com.example.companyspringempoyee.repazitory.CommentRepazitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepazitory commentRepazitory;
    public List<Comment> getAllCommentsByTopicId(int id){
        return commentRepazitory.findAllByTopicId(id);
    }

    public void saveComment(Comment comment){
        commentRepazitory.save(comment);
    }
}
