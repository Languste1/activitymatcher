package com.example.actvitymatcher.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200/api")
public class UserController {


    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("/text")
    public ResponseEntity<String> processText(@RequestBody String text) {
        // Verarbeite den empfangenen Text hier
        System.out.println("Empfangener Text: " + text);

        // Gib eine Antwort zurück (optional)
        String response = "Text erfolgreich empfangen";
        return ResponseEntity.ok(response);
    }


}
