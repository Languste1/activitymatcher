package com.example.actvitymatcher;

import com.example.actvitymatcher.activities.ActivityRepository;
import com.example.actvitymatcher.images.ImageRepository;
import com.example.actvitymatcher.user.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        SpringApplication.run(Application.class, args);
    }
}
