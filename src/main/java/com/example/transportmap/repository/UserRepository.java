package com.example.transportmap.repository;

import com.example.transportmap.model.User;

import java.util.List;
import java.util.Map;

public interface UserRepository {
    int saveUser(User user);

    List<User> getUsers();

    User getUser(int id);

    List<User> getUsers(String name);

    Map<Integer, Integer> getUserCountByAge();
}
