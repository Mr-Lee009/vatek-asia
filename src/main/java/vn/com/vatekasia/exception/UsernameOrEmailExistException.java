package vn.com.vatekasia.exception;

import org.springframework.security.core.AuthenticationException;

public class UsernameOrEmailExistException extends AuthenticationException {
    public UsernameOrEmailExistException(String msg) {
        super(msg);
    }
}
