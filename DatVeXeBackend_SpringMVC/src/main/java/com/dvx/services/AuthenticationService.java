package com.dvx.services;

import com.dvx.dto.AuthenticationRequest;
import com.dvx.dto.AuthenticationResponse;
import com.dvx.dto.RegisterRequest;




public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
    AuthenticationResponse register(RegisterRequest registerRequest);

//    AuthenticationResponse loginWithGoogle(LoginWithGoogleRequest data);
}