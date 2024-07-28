package dev.skullbug.demo.skullbug;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class SkullbugController {

    private Map<String, Bug> db = new HashMap<>() {{
        put("1", new Bug("1", "Bug1"));
    }};

    @GetMapping("/")
    public String hello() {
        return "Hello Skullbug";
    }

    @GetMapping("/bugs")
    public Collection<Bug> get() {
        return db.values();
    }

    @GetMapping("/bugs/{id}")
    public Bug get(@PathVariable String id) {
        Bug bug = db.get(id);
        if (bug == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return bug;
    }

    @DeleteMapping("/bugs/{id}")
    public void delete(@PathVariable String id) {
        Bug bug = db.remove(id);
        if (bug == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/bugs")
    public ResponseEntity<Bug> create(@RequestBody @Valid Bug bug) {
        bug.setId(UUID.randomUUID().toString());
        db.put(bug.getId(), bug);
        return new ResponseEntity<>(bug, HttpStatus.CREATED);
    }

}

