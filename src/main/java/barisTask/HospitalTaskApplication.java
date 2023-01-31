package barisTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan
@Configuration

public class HospitalTaskApplication {

    public static void main(String[] args) {
        
        SpringApplication.run(HospitalTaskApplication.class, args);
        
        System.out.println("helloworld");
    }

}
