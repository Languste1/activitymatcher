package com.example.actvitymatcher.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:4200/**")
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        try {
            // Add user to data
            User createdUser = userService.saveUser(userDTO);
            return ResponseEntity.ok(createdUser);

        } catch (Exception e) {
            // Handle the exception and return a ResponseEntity with an appropriate error message
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}