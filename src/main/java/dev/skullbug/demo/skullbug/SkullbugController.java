package dev.skullbug.demo.skullbug;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class SkullbugController {


    private List<Bug> db = List.of(new Bug("1","bug1"));

    @GetMapping ("/")
    public String hello(){
        return "Hello Skullbug";
    }
    @GetMapping ("/bugs")
    public List<Bug> get(){
        return db;
    }
}
