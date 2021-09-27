package com.test.beeline.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public interface UserService {
    void create(InputStream file) throws IOException;
}
