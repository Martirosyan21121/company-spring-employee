package com.example.companyspringempoyee.controlier;

import com.example.companyspringempoyee.model.Employee;
import com.example.companyspringempoyee.model.Message;
import com.example.companyspringempoyee.security.SecurityUser;
import com.example.companyspringempoyee.service.EmployeeService;
import com.example.companyspringempoyee.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final EmployeeService employeeService;
    private final MessageService massageService;

    @GetMapping("/sendMessage")
    private String getAllEmployees(ModelMap modelMap){
        List<Employee> employees = employeeService.findAll();
        modelMap.addAttribute("employees", employees);
        return "message";
    }
    @GetMapping("/allMessages")
    public String getAllMessages(ModelMap modelMap, @AuthenticationPrincipal SecurityUser securityUser) {
        List<Message> message = massageService.findAllMessagesByToId(securityUser.getEmployee().getId());
        modelMap.addAttribute("messages", message);
        return "allMessages";
    }
   @PostMapping("/sendMessage")
    public String sentMesssage(@ModelAttribute Message message, @AuthenticationPrincipal SecurityUser securityUser){
        message.setFromEmployee(securityUser.getEmployee());
        massageService.saveMessage(message);
        return "redirect:/employee";
   }
}
