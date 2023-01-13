package vn.com.vatekasia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc
@EnableWebSecurity
public class WebMVCConfig implements WebMvcConfigurer {

    // bat buoc phai dang ki resource se dung
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry
//                .addResourceHandler("/resources/**")
//                .addResourceLocations("/resources/");
//
//        registry
//                .addResourceHandler("/resources/static/**")
//                .addResourceLocations("/static/");
//
        registry
                .addResourceHandler("/doc/**")
                .addResourceLocations("/doc/");
    }
}
