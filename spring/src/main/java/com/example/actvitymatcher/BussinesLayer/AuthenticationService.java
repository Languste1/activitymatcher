package com.example.actvitymatcher.BussinesLayer;


import com.example.actvitymatcher.DTO.AuthenticationRequest;
import com.example.actvitymatcher.DTO.AuthenticationResponse;
import com.example.actvitymatcher.DTO.RegisterRequest;
import com.example.actvitymatcher.exeptions.UserAlreadyExistsException;
import com.example.actvitymatcher.exeptions.UserDoesntExistException;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {

    /*The AuthenticationService interface defines methods for authenticating users,
    including checking user credentials and generating an authentication response.*/

    //AuthenticationResponse register(RegisterRequest request) throws UserAlreadyExistsException;

    AuthenticationResponse authenticate(AuthenticationRequest request) throws UserDoesntExistException;

}
