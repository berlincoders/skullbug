package dev.skullbug.demo.skullbug;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SkullbugController {


    @GetMapping ("/")
    public String hello(){
        return "Hello Skullbug";
    }
}
