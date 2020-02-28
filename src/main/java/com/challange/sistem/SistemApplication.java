package com.challange.sistem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class SistemApplication implements CommandLineRunner {

    @Resource
    Challenge challenge;
    public static void main(String[] args) {
        SpringApplication.run(SistemApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        challenge.findPIN();
    }
}
