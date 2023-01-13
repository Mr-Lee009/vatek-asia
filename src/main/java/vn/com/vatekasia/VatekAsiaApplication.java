package vn.com.vatekasia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.com.vatekasia.capcha.CapchaGenerater;

@SpringBootApplication
public class VatekAsiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VatekAsiaApplication.class, args);
	}

	@Bean
	public CapchaGenerater createCapchaGenerater(){
		return  new CapchaGenerater();
	}
}
