package vn.com.vatekasia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.vatekasia.dto.ResponseDTO;
import vn.com.vatekasia.entity.EUser;
import vn.com.vatekasia.service.impl.UserServiceImpl;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping(value = "/register")
    public ResponseDTO register(@RequestBody EUser user) {
        try {
            EUser res = userService.register(user);
            return ResponseDTO.builder()
                    .code(HttpStatus.OK.value())
                    .nameCode(HttpStatus.OK.name())
                    .message("Đăng ký thành công")
                    .build();
        } catch (Exception ex) {
            return ResponseDTO.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .nameCode(HttpStatus.BAD_REQUEST.name())
                    .message(ex.getMessage())
                    .build();
        }
    }

    @GetMapping(value = "/login")
    public ResponseDTO login(@RequestParam String username, @RequestParam String password) {
        String res = userService.login(username, password);
        if (res == null)
            return ResponseDTO.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .nameCode(HttpStatus.BAD_REQUEST.name())
                    .message("Tên đăng nhập hoặc mật khẩu không hợp lệ!")
                    .build();
        return ResponseDTO.builder()
                .code(HttpStatus.OK.value())
                .nameCode(HttpStatus.OK.name())
                .message("Login thành công!")
                .data(res)
                .build();
    }

    @GetMapping(value = "/home")
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("Home", HttpStatus.OK);
    }
}
