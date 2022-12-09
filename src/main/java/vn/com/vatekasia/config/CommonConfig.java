package vn.com.vatekasia.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import vn.com.vatekasia.enumeration.EHmacAlgorithm;
import vn.com.vatekasia.util.HasingAlogirthm;
import vn.com.vatekasia.util.JwtUtil;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Configuration
@RequiredArgsConstructor
public class CommonConfig {
    private final HasingAlogirthm hasingAlogirthm;

    @Bean
    public JwtUtil jwtUtil(@Value("${jwt.secret.key}") String secretKey)
            throws NoSuchAlgorithmException, InvalidKeyException {
        return new JwtUtil(hasingAlogirthm.hasingWithJava(EHmacAlgorithm.HmacSHA256, secretKey));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
