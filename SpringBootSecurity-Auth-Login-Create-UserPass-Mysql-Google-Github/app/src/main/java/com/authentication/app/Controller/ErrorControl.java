package com.authentication.app.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorControl implements ErrorController  {
    @RequestMapping
    public String hi(){
        return "redirect:/dashboard";
    }
    @RequestMapping("/error")
    public String handleError(Model model,HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object message = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        Object uri = request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
        System.out.println(message);
        model.addAttribute("Status", status);
        model.addAttribute("Message", message);
        model.addAttribute("Uri", uri);
        return "error";
    }
}