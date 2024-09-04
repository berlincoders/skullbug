package dev.skullbug.demo.skullbug.dto;

public class AccountDTO {
    private Long id;
    private String username;
    private String email;
    // Add other fields as necessary

    // Default constructor
    public AccountDTO() {
    }

    // Parameterized constructor
    public AccountDTO(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
