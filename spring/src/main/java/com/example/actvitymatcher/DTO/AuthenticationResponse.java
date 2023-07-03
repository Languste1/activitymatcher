package com.example.actvitymatcher.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

/*The parameters to be expected in a response*/
public class AuthenticationResponse {

    private  String username;
    private String password;
    //private String token;
    //private String role;



}
