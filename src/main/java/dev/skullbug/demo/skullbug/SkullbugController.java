package dev.skullbug.demo.skullbug;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@RestController
public class SkullbugController {


    private Map<String, Bug> db =new HashMap<>() {{

        put("1", new Bug("1","Bug1"));

    }};


    @GetMapping ("/")
    public String hello(){
        return "Hello Skullbug";
    }
    @GetMapping ("/bugs")
    public Collection<Bug> get(){
        return db.values();
    }
    @GetMapping ("/bugs/{id}")
    public Bug get(@PathVariable String id){
        Bug bug = db.get(id);
        if (bug == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return bug;
    }

    @DeleteMapping("/bugs/{id}")
    public void delete(@PathVariable String id){
        Bug bug = db.remove(id);
        if (bug == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}

