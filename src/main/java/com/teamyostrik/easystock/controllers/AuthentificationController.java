package com.teamyostrik.easystock.controllers;

import com.teamyostrik.easystock.dto.auth.AuthenticationRequest;
import com.teamyostrik.easystock.dto.auth.AuthentificationResponse;
import com.teamyostrik.easystock.models.auth.ExtendedUser;
import com.teamyostrik.easystock.services.authentification.ApplicationUserDetailsService;
import com.teamyostrik.easystock.utils.Constants;
import com.teamyostrik.easystock.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.APP_ROOT + "auth")
public class AuthentificationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ApplicationUserDetailsService applicationUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/login")
    public ResponseEntity<AuthentificationResponse> login(@RequestBody AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        final UserDetails userDetails = applicationUserDetailsService.loadUserByUsername(request.getLogin());
        final String jwt = jwtUtil.generateToken((ExtendedUser) userDetails);
        return ResponseEntity.ok(AuthentificationResponse.builder().accessToken(jwt).build());
    }
}
