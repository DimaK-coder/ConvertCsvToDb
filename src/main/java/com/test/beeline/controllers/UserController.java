package com.test.beeline.controllers;

import com.test.beeline.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping(value = "/api/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/uploadCSVFile")
    public void uploadSingleCSVFile(@RequestParam("csvfile") MultipartFile csvfile) throws IOException {
        InputStream file = csvfile.getInputStream();
        this.userService.create(file);
    }
}
