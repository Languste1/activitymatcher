package com.example.actvitymatcher.user;

import com.example.actvitymatcher.BussinesLayer.AuthenticationService;
import com.example.actvitymatcher.DTO.AuthenticationRequest;
import com.example.actvitymatcher.exeptions.UserDoesntExistException;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final ObjectMapper objectMapper;
    private final UserRepository userRepository;
    private final UserService userService;
    private final AuthenticationService authenticationService;



    //register user with userDTO from frontend
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

    // authenticate with request data from frontend
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request){
        try{

            //DTO in JSON umwandeln
            try {
                String json = objectMapper.writeValueAsString(authenticationService.authenticate(request));
                System.out.println(authenticationService.authenticate(request));
                System.out.println(request);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            return ResponseEntity.ok (authenticationService.authenticate(request));
        }catch (UserDoesntExistException e){
            return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (e.getMessage ());
        }


    }
}