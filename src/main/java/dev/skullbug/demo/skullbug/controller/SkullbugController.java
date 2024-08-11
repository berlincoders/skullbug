package dev.skullbug.demo.skullbug.controller;

import dev.skullbug.demo.skullbug.model.Bug;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Controller for managing bugs.
 */
@RestController
@RequestMapping("/api/bugs")
public class SkullbugController {

    private final Map<String, Bug> db = new HashMap<>() {{
        put("1", new Bug("1", "Bug1"));
    }};

    /**
     * Test endpoint.
     * @return greeting message
     */
    @GetMapping("/")
    public String hello() {
        return "Hello Skullbug";
    }

    /**
     * Get all bugs.
     * @return collection of bugs
     */
    @GetMapping
    public Collection<Bug> getAllBugs() {
        return db.values();
    }

    /**
     * Get a bug by ID.
     * @param id the bug ID
     * @return the bug
     * @throws ResponseStatusException if bug not found
     */
    @GetMapping("/{id}")
    public Bug getBugById(@PathVariable String id) {
        Bug bug = db.get(id);
        if (bug == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bug not found");
        return bug;
    }

    /**
     * Delete a bug by ID.
     * @param id the bug ID
     * @throws ResponseStatusException if bug not found
     */
    @DeleteMapping("/{id}")
    public void deleteBug(@PathVariable String id) {
        Bug bug = db.remove(id);
        if (bug == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bug not found");
    }

    /**
     * Create a new bug.
     * @param bug the bug to create
     * @return the created bug
     */
    @PostMapping
    public ResponseEntity<Bug> createBug(@RequestBody @Valid Bug bug) {
        bug.setId(UUID.randomUUID().toString());
        db.put(bug.getId(), bug);
        return new ResponseEntity<>(bug, HttpStatus.CREATED);
    }

}
