package com.example.actvitymatcher.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String username;
    private String email;
    private String password;
    //private String image;

    public UserDTO(User user) {
        this.username = user.getUsername();
        //Check if this works! Datatype in User-class is byte!
        this.email = user.getEmail();
        this.password = user.getPassword();
        //this.image = Arrays.toString(user.getImage());
    }
}
