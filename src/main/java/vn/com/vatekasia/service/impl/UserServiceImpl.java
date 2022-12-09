package vn.com.vatekasia.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.com.vatekasia.entity.EUser;
import vn.com.vatekasia.enumeration.EUserRole;
import vn.com.vatekasia.exception.InvalidInputException;
import vn.com.vatekasia.exception.UsernameOrEmailExistException;
import vn.com.vatekasia.repository.EUserRepository;
import vn.com.vatekasia.util.JwtUtil;

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {
    private final EUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    private EUser findUserByUsernameOrEmail(String username, String email) {
        return userRepository.findEUserByUsernameOrEmail(username, email);
    }

    public String login(String username, String password) {
        EUser user = findUserByUsernameOrEmail(username, username);
        if (user == null || !passwordEncoder.matches(password, user.getPassword()))
            return null;
        return jwtUtil.generateToken(loadUserByUsername(user.getUsername()));
    }

    public EUser register(EUser user) {
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())
                || StringUtils.isBlank(user.getEmail()))
            throw new InvalidInputException("Dữ liệu đầu vào không hợp lệ!");
        EUser findUser = findUserByUsernameOrEmail(user.getUsername(), user.getEmail());
        if (findUser != null)
            throw new UsernameOrEmailExistException("Username hoặc email đã tồn tại!");;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(EUserRole.user);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        EUser user = userRepository.findEUserByUsername(s);
        if (user == null)
            return null;
        Collection<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().name()));
        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
