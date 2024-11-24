package org.example.hwspringweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Configuration
@RestController
public class HwSpringWebApplication {

    @Autowired
    ShopService shopService;

    public static void main(String[] args) {
        SpringApplication.run(HwSpringWebApplication.class, args);
    }

}
