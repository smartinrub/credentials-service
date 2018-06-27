package org.smartinrub.credentialsservice.controllers;

import lombok.RequiredArgsConstructor;
import org.smartinrub.credentialsservice.exceptions.CredentialsNotFoundException;
import org.smartinrub.credentialsservice.grpc.BCryptClient;
import org.smartinrub.credentialsservice.models.Credentials;
import org.smartinrub.credentialsservice.repositories.CredentialsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class CredentialsController {

    private final CredentialsRepository credentialsRepository;

    private final BCryptClient bCryptClient;

    @GetMapping("/save")
    public ModelAndView index() {
        return new ModelAndView("index", "credentials", new Credentials());
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveCredentials(@ModelAttribute("credentials") Credentials credentials) {
        credentialsRepository.save(credentials);
        return "success";
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login", "credentials", new Credentials());
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@ModelAttribute("credentials") Credentials credentials)  {
        credentialsRepository.findByEmail(
                credentials.getEmail()).orElseThrow(() -> new CredentialsNotFoundException(credentials.getEmail()));

        if (bCryptClient.checkHashedPassword(credentials.getPassword())) {
            return "success";
        }

        return "denied";
    }

}
