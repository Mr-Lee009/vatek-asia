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

//        .addFilterBefore(authenticationFilter(),
//                UsernamePasswordAuthenticationFilter.class)
//        http.addFilterBefore()
//
        http.cors().and().csrf().disable().
                authorizeRequests()
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
    }

}
