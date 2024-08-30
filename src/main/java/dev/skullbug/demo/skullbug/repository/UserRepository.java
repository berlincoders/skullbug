package dev.skullbug.demo.skullbug.repository;

import dev.skullbug.demo.skullbug.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional query methods (if needed) can be defined here
}
