package vn.com.vatekasia.filter;

import org.springframework.lang.Nullable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        UsernamePasswordAuthenticationToken authRequest = getAuth(request);
        setDetails(request, authRequest);
        return getAuthenticationManager().authenticate(authRequest);
    }

    private UsernamePasswordAuthenticationToken getAuth(HttpServletRequest request) {
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        String customToken = obtainCustomCaptcha(request);

        String usernameDomain = String.format("%s%s%s", username.trim(), String.valueOf(Character.LINE_SEPARATOR), customToken);

        return new UsernamePasswordAuthenticationToken(
                usernameDomain, password);
    }
    @Nullable
    protected String obtainCustomCaptcha(HttpServletRequest request) {
        return request.getParameter("captcha");
    }

}
