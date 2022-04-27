package edu.tcu.cs.superfrogscheduler.controller;

import edu.tcu.cs.superfrogscheduler.domain.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SuperfrogController {
    @GetMapping("/superfrogs")
    public Result findAll(){

    }
}
