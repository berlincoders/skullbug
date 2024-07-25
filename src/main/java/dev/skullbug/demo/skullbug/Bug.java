package dev.skullbug.demo.skullbug;

public class Bug {

    private String id;
    private String Name;

    // Empty Constructor

    public Bug() {
    }
    // Generate Constructor
    public Bug(String id, String name) {
        this.id = id;
        Name = name;
    }
    // Add getters and setters
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
