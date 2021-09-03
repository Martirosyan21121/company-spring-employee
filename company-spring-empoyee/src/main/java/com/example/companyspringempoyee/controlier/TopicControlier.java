package com.example.companyspringempoyee.controlier;

import com.example.companyspringempoyee.model.Comment;
import com.example.companyspringempoyee.model.Topic;
import com.example.companyspringempoyee.security.SecurityUser;
import com.example.companyspringempoyee.service.CommentService;
import com.example.companyspringempoyee.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class TopicControlier {

    private final TopicService topicService;
    private final CommentService commentService;

    @GetMapping("/addTopic")
    public String addTopic() {
        return "addTopic";
    }

    @GetMapping("/topics")
    public String Topics(ModelMap modelMap, @AuthenticationPrincipal SecurityUser securityUser) {
        List<Topic> all = topicService.findAllByCompanyId(securityUser.getEmployee().getCompanyId().getId());
        modelMap.addAttribute("topics", all);
        return "topic";
    }
    @PostMapping("/addTopic")
    public String addTopic(@AuthenticationPrincipal SecurityUser securityUser, @ModelAttribute Topic topic){
        topic.setCreateDate(new Date());
        topic.setEmployee(securityUser.getEmployee());
        topicService.saveTopic(topic);
        return "redirect:/topics";

    }
    @GetMapping("/topics/{id}")
    public String showMore(@PathVariable("id") int id, ModelMap modelMap) {
        Optional<Topic> topic = topicService.findTopicById(id);
        if (!topic.isEmpty()){
            return "redirect:/topics";
        }
        List<Comment> comment = commentService.getAllCommentsByTopicId(id);
        modelMap.addAttribute("comments",comment);
        modelMap.addAttribute("topic",topic.get());
        return "singleTopic";
    }
}
