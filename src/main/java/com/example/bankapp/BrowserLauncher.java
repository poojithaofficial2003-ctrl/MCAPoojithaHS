package com.example.bankapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BrowserLauncher implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        Thread.sleep(4000); // wait for Spring Boot to start

        Runtime.getRuntime().exec("cmd /c start http://localhost:8080/login");

    }
}