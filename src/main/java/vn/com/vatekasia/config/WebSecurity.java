package vn.com.vatekasia.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable().authorizeRequests()
                .antMatchers("/web/**").hasRole("manager")
                .anyRequest().authenticated()
                .and()
                .formLogin();

        //Trang chỉ dành cho ADMIN
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        System.out.println("Check url ABC");
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
    }

    @Override
    public void configure(org.springframework.security.config.annotation.web.builders.WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/css/**",
                "/js/**",
                "/img/**"
        );
    }
}
