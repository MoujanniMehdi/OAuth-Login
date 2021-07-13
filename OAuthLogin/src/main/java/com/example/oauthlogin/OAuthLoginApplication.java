package com.example.oauthlogin;

import com.example.oauthlogin.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class OAuthLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuthLoginApplication.class, args);
    }

}
