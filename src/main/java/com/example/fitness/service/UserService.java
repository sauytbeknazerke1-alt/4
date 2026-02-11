package com.example.fitness.service;

import com.example.fitness.dao.UserDAO;
import com.example.fitness.exception.ResourceNotFoundException;
import com.example.fitness.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDAO dao;

    public UserService(UserDAO dao) {
        this.dao = dao;
    }

    public User getUser(int id) {
        User user = dao.findById(id);
        if (user == null)
            throw new ResourceNotFoundException("User not found");
        return user;
    }

    public void createUser(User user) {
        dao.save(user);
    }

    public void updateUser(User user) {
        if (dao.findById(user.getId()) == null)
            throw new ResourceNotFoundException("User not found");
        dao.update(user);
    }

    public void deleteUser(int id) {
        if (dao.findById(id) == null)
            throw new ResourceNotFoundException("User not found");
        dao.delete(id);
    }
}


