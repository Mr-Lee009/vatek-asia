package vn.com.vatekasia.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import vn.com.vatekasia.config.security.JwtRequestFilter;
import vn.com.vatekasia.service.impl.UserServiceImpl;

@EnableWebSecurity
@RequiredArgsConstructor
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {
    private final JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable().authorizeRequests()
                .antMatchers("/register", "/login", "http://localhost:8081/swagger-ui.html/**").permitAll()
                .antMatchers("/web/**").hasRole("manager")
                .anyRequest().authenticated();

        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
        http.authorizeRequests()
                .and()
                    .formLogin()
                    .loginProcessingUrl("/web/login")
                    .loginPage("/web/login").permitAll() //luon cho di vao trang nay
                    .defaultSuccessUrl("/web/home")
                    .failureUrl("/web/login?error=true")
                    .usernameParameter("username")
                    .passwordParameter("password")

                .and()
                    .logout()
                    .logoutUrl("/logout_admin")
                    .logoutSuccessUrl("/web/login")
                    .deleteCookies("JSESSIONID");

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/css/**",
                "/js/**",
                "/img/**"
        );
    }
}
