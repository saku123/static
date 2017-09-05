package org.learning.statics.web;

import org.learning.statics.model.Contents;
import org.learning.statics.service.ContentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContentsController {
    @Autowired
    private ContentsService contentsService;


    @RequestMapping("/")
    String home() {
        return "Hello World";
    }

    @RequestMapping("/static/{tutorialName}")
    List<Contents> contents(@PathVariable String tutorialName) {
        return contentsService.queryContents(tutorialName);
    }
}