package fon.bg.ac.rs.retailApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"fon.bg.ac.rs.retailApp"})
public class RetailAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetailAppApplication.class, args);
    }

}
