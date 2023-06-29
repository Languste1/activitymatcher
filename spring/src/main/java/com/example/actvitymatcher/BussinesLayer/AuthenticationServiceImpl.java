package com.example.actvitymatcher.BussinesLayer;

import com.example.actvitymatcher.DTO.AuthenticationRequest;
import com.example.actvitymatcher.DTO.AuthenticationResponse;
import com.example.actvitymatcher.exeptions.UserDoesntExistException;
import com.example.actvitymatcher.user.UserRepository;
import com.mysql.cj.exceptions.PasswordExpiredException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) throws UserDoesntExistException {
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UserDoesntExistException("User with the given username doesn't exist"));

        var password = userRepository.findByPassword(request.getPassword())
                .orElseThrow(() -> new PasswordExpiredException("Password doesn't exist"));


        return new AuthenticationResponse(user.getUsername(), password.getPassword());
    }
}





