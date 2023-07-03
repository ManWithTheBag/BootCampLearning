package org.doit.bootcamplearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"org.doit"})
public class BootCampLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootCampLearningApplication.class, args);
    }

}
