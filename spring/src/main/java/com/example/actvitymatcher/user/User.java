package com.example.actvitymatcher.user;



import lombok.*;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class User {

    @Id
    //Needs to be changed in random user-id!
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(unique = true)
    private String username;

    private String email;

    private String password;

    /*
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;
     */




}
