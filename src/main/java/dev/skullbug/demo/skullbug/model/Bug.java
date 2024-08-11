package dev.skullbug.demo.skullbug.model;

import jakarta.validation.constraints.NotEmpty;

public class Bug {

    private String id;
    @NotEmpty
    private String name;

    // Empty Constructor
    public Bug() {
    }

    // Generate Constructor
    public Bug(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Add getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}