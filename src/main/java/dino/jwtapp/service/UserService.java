package dino.jwtapp.service;

import dino.jwtapp.model.User;

import java.util.List;

public interface UserService
{
    void save (User user);

    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    boolean deleteByUsername(String username);

    User findById(Long id);

    void delete(Long id);
}
