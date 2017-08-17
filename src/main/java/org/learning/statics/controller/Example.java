package org.learning.statics.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class Example {

    @Value("${db.url}")
    private String url;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        System.out.print(url);
        return url;
    }
}