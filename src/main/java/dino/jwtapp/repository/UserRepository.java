package dino.jwtapp.repository;

import dino.jwtapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
    User findByUsername(String name);
    void deleteByUsername(String login);
}
