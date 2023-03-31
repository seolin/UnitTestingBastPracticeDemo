package com.simple.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author older
 */
@SpringBootApplication(scanBasePackages = "com.hellobike.testing")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
