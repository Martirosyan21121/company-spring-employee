package com.example.companyspringempoyee.controlier;

import com.example.companyspringempoyee.model.Comment;
import com.example.companyspringempoyee.security.SecurityUser;
import com.example.companyspringempoyee.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;


    @PostMapping("/addComment")
    public String addComment(@ModelAttribute Comment comment, @AuthenticationPrincipal SecurityUser securityUser){
        comment.setEmployee(securityUser.getEmployee());
        comment.setCreateDate(new Date());
        commentService.saveComment(comment);
        return "redirect:/singleTopic/" + comment.getTopic().getId();
    }
}
