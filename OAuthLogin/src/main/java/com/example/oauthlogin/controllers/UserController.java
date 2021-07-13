package com.example.oauthlogin.controllers;



import com.example.oauthlogin.exceptions.ResourceNotFoundException;
import com.example.oauthlogin.models.User;
import com.example.oauthlogin.repositories.UserRepository;
import com.example.oauthlogin.security.CurrentUser;
import com.example.oauthlogin.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
