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
        this.email = user.getEmail();
        this.password = user.getPassword();

        //todo implement when pictures can be saved in db
        //this.image = Arrays.toString(user.getImage());
    }
}
