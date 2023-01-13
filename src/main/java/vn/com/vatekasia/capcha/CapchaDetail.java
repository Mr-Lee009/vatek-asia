package vn.com.vatekasia.capcha;

import nl.captcha.Captcha;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public class CapchaDetail implements Serializable {
    private final String answer;
    private final Captcha captcha;

    public CapchaDetail(HttpServletRequest request) {
        this.answer = request.getParameter("captcha");
        this.captcha = (Captcha) WebUtils.getSessionAttribute(request, "captcha");
    }

    public String getAnswer() {
        return answer;
    }

    public Captcha getCaptcha() {
        return captcha;
    }


}
