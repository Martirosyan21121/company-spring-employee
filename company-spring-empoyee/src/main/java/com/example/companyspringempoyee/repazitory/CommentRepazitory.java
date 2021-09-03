package com.example.companyspringempoyee.repazitory;

import com.example.companyspringempoyee.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepazitory extends JpaRepository<Comment, Integer> {

    List<Comment> findAllByTopicId(int id);

}
