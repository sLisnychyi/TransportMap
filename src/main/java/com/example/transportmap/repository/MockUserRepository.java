package com.example.transportmap.repository;

import com.example.transportmap.model.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Profile("dev")
public class MockUserRepository implements UserRepository {
    private final List<User> users;

    public MockUserRepository() {
        this.users = new ArrayList<>();
    }

    @Override
    public int saveUser(User user) {
         users.add(user);
         return 0;
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public List<User> getUsers(String name) {
        return null;
    }

    @Override
    public Map<Integer, Integer> getUserCountByAge() {
        return null;
    }
}
