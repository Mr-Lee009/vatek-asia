package vn.com.vatekasia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequestMapping(value = "/web")
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @ResponseBody
    public String home(Model model) {
        return "day la trang home!";
    }
}
