package dev.skullbug.demo.skullbug.repository;

import dev.skullbug.demo.skullbug.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
