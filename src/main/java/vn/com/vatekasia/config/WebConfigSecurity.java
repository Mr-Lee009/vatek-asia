package vn.com.vatekasia.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/img/*", "/css/**", "/js/**", "/home", "/login").permitAll()
                .antMatchers("/web/**").hasRole("manager")
                .anyRequest().authenticated()
                //http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
                //http.authorizeRequests()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll() //luon cho di vao trang nay
                    .defaultSuccessUrl("/web/home")
                    .usernameParameter("uname")
                    .passwordParameter("psw")
                    .failureUrl("/login?error=true")
                .and()
                    .logout()
                    .logoutUrl("/logout_admin")
                    .logoutSuccessUrl("/login")
                    .deleteCookies("JSESSIONID");

//        http.csrf().disable().authorizeRequests()
//                .antMatchers("/","/home","/login","/about","/help","/register","/cart/**").permitAll()
//                .antMatchers(
//                "/css/**",
//                "/js/**",
//                "/img/**").permitAll()
//                .antMatchers("/user/**").hasRole("USER")
//                .antMatchers("/admin/**","/product/new").hasRole("ADMIN")
//                .antMatchers("/web/**").hasRole("manager")
//
//                .and()
//                        .formLogin()
//                        .loginPage("/login")
//                        .permitAll()
//                        .defaultSuccessUrl("/web/home")
//                        .failureUrl("/web/login?error=true")
//                .and()
//                        .logout()
//                        .invalidateHttpSession(true)
//                        .clearAuthentication(true)
//                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
//                        .and()
//                .headers().frameOptions().sameOrigin();
    }

}
