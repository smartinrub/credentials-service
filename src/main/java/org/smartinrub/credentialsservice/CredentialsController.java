package org.smartinrub.credentialsservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CredentialsController {

    private final CredentialsRepository credentialsRepository;

    public CredentialsController(CredentialsRepository credentialsRepository) {
        this.credentialsRepository = credentialsRepository;
    }

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

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> login(@RequestBody Credentials credentials) {


        return ResponseEntity.ok().build();
    }

}
