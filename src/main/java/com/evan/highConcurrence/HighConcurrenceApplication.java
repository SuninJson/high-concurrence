package com.evan.highConcurrence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Evan Huang
 * @date 2018-9-6
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class HighConcurrenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HighConcurrenceApplication.class, args);
    }
}
