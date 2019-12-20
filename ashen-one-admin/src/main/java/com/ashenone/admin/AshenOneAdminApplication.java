package com.ashenone.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author panguangze
 * @date 2019/11/1
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.ashenone.db.entity"})
@EnableJpaRepositories(basePackages = {"com.ashenone.db.repository"})
@ComponentScan("com.ashenone")
public class AshenOneAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AshenOneAdminApplication.class, args);
    }
}
