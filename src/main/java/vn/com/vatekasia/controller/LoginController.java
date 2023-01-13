package vn.com.vatekasia.controller;

import nl.captcha.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.com.vatekasia.capcha.CapchaGenerater;
import vn.com.vatekasia.capcha.CaptchaUtil;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    CapchaGenerater capchaGenerater;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(name = "error", required = false) String error,
                              Model model,
                              HttpSession session) {
        //create captcha
        Captcha captcha = capchaGenerater.createCaptcha(200, 50);
        session.setAttribute("captcha", captcha);
        model.addAttribute("captchaEncode", "data:image/png;base64," + CaptchaUtil.endCodeBase64(captcha));

        if ("true".equals(error) || null == error) {
            model.addAttribute("message", "tai khoan hoac mat khau ko chinh xác!");
        }
        return new ModelAndView("login.html");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        return new ModelAndView("register.html");
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied() {
        return "403";
    }
}
