package com.example.companyspringempoyee.controlier;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexControlier {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
