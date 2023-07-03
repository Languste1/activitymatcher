package com.example.actvitymatcher;

import com.example.actvitymatcher.activities.ActivityRepository;
import com.example.actvitymatcher.images.ImageRepository;
import com.example.actvitymatcher.user.User;
import com.example.actvitymatcher.user.UserRepository;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

import javax.swing.text.html.parser.Parser;
import java.io.File;

@SpringBootApplication
public class Application {

    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final ImageRepository imageRepository;
    private final Faker faker = new Faker();


    public Application(UserRepository userRepository,
                       ActivityRepository activityRepository,
                       ImageRepository imageRepository) {
        this.userRepository = userRepository;
        this.activityRepository = activityRepository;
        this.imageRepository = imageRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);    }

    @PostConstruct
    @Transactional
    public void dummyData() {
        createUserData();
    }


    public void createUserData() {

        for (int i = 0; i < 7; i++) {
            User user = new User();
            user.setUsername(faker.harryPotter().character());
            user.setEmail(faker.internet().emailAddress());
            user.setPassword(faker.internet().password());
            userRepository.save(user);
        }
    }



}
