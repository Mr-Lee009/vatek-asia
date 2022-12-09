package vn.com.vatekasia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.com.vatekasia.entity.EUser;
import vn.com.vatekasia.service.impl.UserServiceImpl;

@Controller
@RequestMapping(value = "/web")
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(Model model) {
        model.addAttribute("message", "hello world");
        return new ModelAndView("home.html!");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(name = "error", required = false) String error,
                              Model model) {
        if ("true".equals(error) || null == error) {
            model.addAttribute("message", "tai khoan hoac mat khau ko chinh xác!");
        }
        return new ModelAndView("login.html");
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied() {
        return "403";
    }

}
