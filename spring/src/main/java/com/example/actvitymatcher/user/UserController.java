package com.example.actvitymatcher.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {


    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @CrossOrigin(origins = "http://localhost:4200/**")
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        try {
            System.out.println(userDTO.getUsername());
            // Add your logic here

            // Return a ResponseEntity instance
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println("Kein user");
            // Handle the exception and return a ResponseEntity with an appropriate error message
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}








