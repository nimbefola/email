package com.pentspace.emailservice.endpoints;

import com.pentspace.emailservice.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "notification")
@CrossOrigin(origins = "*")
public class EmailEndpoint {
    @Autowired
    private EmailService emailService;

    @PostMapping( produces = "application/json", consumes = "application/json")
    private ResponseEntity<String> sendEmail(@RequestParam("email") String email, @RequestParam("otp") String otp, @RequestParam("title") String title ){
        return new ResponseEntity<>(emailService.sendEmail(email, otp, title), HttpStatus.OK);
    }

}
