package com.example.actvitymatcher.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

/*The parameters to be expected when requesting registration*/

public class RegisterRequest {

   private String username;
    private String email;
    private String password;

}
